

// //sql query, relational query, relational algebra is not there

package CloudGame;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.Timer;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;

public class Window extends Canvas implements Runnable {

    private KeyboardHandler KeyListener = new KeyboardHandler(this);
    private Thread thread;
    private boolean running = false;
    Color skyblue = Color.decode("#87CEEB");
    public int points = 0;

    public Player player = new Player(this, 100, 100, 64,128, points);
    public CloudGenerator level = new CloudGenerator();

    ArrayList<Cloud> clouds = new ArrayList<>();
    private Random random = new Random();
    private JFrame frame;

    public Window() {
        frame = new JFrame();
        JLabel pointsDisplay = new JLabel();
        pointsDisplay.setText("Points: ");
        pointsDisplay.setFont(new Font("MV Boli", Font.PLAIN, 40));
        pointsDisplay.setForeground(Color.blue);
        pointsDisplay.setVerticalAlignment(JLabel.CENTER);
        pointsDisplay.setHorizontalAlignment(JLabel.CENTER);

        frame.add(pointsDisplay);
        frame.add(this);

        frame.setVisible(true);
        frame.setSize(1600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         for (int i = 0; i < 8; i++) {
            spawnCloud();
        }
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
        Timer timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                EndPage endpage = new EndPage(player.points); 
                frame.dispose();                
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void stop() {
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

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            Render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public void tick() {
        player.tick();

        for (int i = clouds.size() - 1; i >= 0; i--) {
            Cloud cloud = clouds.get(i);
            cloud.y += 2; 
        

            if (cloud.y > this.getHeight()) {
                clouds.remove(i);
                spawnCloud(); 
            }
        }

        }

    public void Render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            bs = this.getBufferStrategy();
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(skyblue);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Cloud cloud : clouds) {
            cloud.Render(g);
        }
        player.Render(g);
        g.setColor(Color.BLACK); 
        g.setFont(new Font("MV Boli", Font.PLAIN, 40)); 
        g.drawString("Points: "+ player.points, 100, 100);

        bs.show();
        g.dispose();
    }

    private void spawnCloud() {
        int x = level.min + random.nextInt(level.getMaxx() - level.min + 1);
        int y = level.min + random.nextInt(level.maxy - level.min + 1);
        int width = 180;
        int height = 70;
        clouds.add(new Cloud(x, y, width, height));
    }
}
