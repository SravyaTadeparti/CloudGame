package CloudGame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyFrame extends JFrame implements KeyListener{
    Color lightBlue = new Color(173, 216, 230);
    JLabel label;

    private KeyboardHandler Klistener = new KeyboardHandler(this);

    public Player player = new Player(0, 0, 100, 100);

    MyFrame(){

        this.setTitle("Testing window");
        this.setSize(1400, 900);
        this.getContentPane().setBackground(lightBlue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        this.setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("game_icon.png");
        this.setIconImage(image.getImage());

        ImageIcon girl = new ImageIcon("girl.png"); 
        Image resizedImage = girl.getImage().getScaledInstance(100, 235, Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(resizedImage); 

        label = new JLabel();
        label.setBackground(lightBlue);
        label.setOpaque(true);
        label.setIcon(resizedIcon);
        // label.setBounds(0, 0, 220, 475);

        this.add(label, BorderLayout.SOUTH);
    }


    public void CloudGeneration(JLabel cloud){

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = label.getX();
        int y = label.getY();

        // Move left or right
        if (e.getKeyChar() == 'a'){
            x-=10;
        } 
        if (e.getKeyChar() == 'd'){
            x += 10; 
            x+=10;
        } 

        // Move up or down
        if (e.getKeyChar() == 'w') y -= 10;
        if (e.getKeyChar() == 's') y += 10;

        label.setLocation(x, y);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
