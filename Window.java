package CloudGame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.*;

public class Window extends Canvas implements Runnable{

    private KeyboardHandler KeyListener = new KeyboardHandler(this);
    private Thread thread;
    private boolean running = false;

    public Player player = new Player(this, 100, 100, 64, 64);
    public LevelHandler level = new LevelHandler();

    // public int gravity = -10;
    public Window(){
        JFrame frame = new JFrame();

        frame.setVisible(true);
        frame.add(this);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
        
    }
    public void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
	    long lastTime = System.nanoTime();
	    double amountOfTicks = 60.0;
	    double ns = 1000000000 / amountOfTicks;
	    double delta = 0;
	    long timer = System.currentTimeMillis();
	    int updates = 0;
	    int frames = 0;
	    
	    while (running)
	    {
	        long now = System.nanoTime();
	        delta += (now - lastTime) / ns;
	        lastTime = now;
	        while (delta >= 1)
	        {
	            tick();
	            updates++;
	            delta--;
	        }
	        Render();
	        frames++;
	        if (System.currentTimeMillis() - timer > 1000)
	        {
	            timer += 1000;
	            System.out.println("FPS: " + frames + " TICKS: " + updates);
	            frames = 0;
	            updates = 0;
	        }
	    }
	    
	     stop();
	}

    public void tick(){
        player.tick();
    }
    public void Render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();  
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        player.Render(g);
        bs.show();
        g.dispose();
    }
}
