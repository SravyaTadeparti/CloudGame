package CloudGame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.util.Timer;



public class StartPage extends JFrame implements ActionListener {
    Color lightBlue = new Color(173, 216, 230);

    JButton button;
    StartPage(){
        System.out.println("HIIII");
        JPanel paneltop = new JPanel();
        JPanel panelmiddle = new JPanel();
        JPanel panelbottom = new JPanel();
        paneltop.setBackground(lightBlue);
        panelbottom.setBackground(lightBlue);
        panelmiddle.setBackground(lightBlue);
    
        // ImageIcon icon = new ImageIcon("cloud.png");
        ImageIcon icon = new ImageIcon(getClass().getResource("cloud.png"));

        

        // Border border = BorderFactory.createLineBorder(Color.green, 3);
        JLabel label = new JLabel();
        label.setText("<html>    Want to play?<br>Click the player to start moving<br>Keys: w,a,d,s. You have 30 seconds!</html>");
        label.setFont(new Font("MV Boli", Font.PLAIN, 40));
        // label.setBorder(border);

        label.setForeground(Color.blue);
        // label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JLabel label2 = new JLabel();
        label2.setIcon(icon);

        button = new JButton();

        paneltop.add(label);
        panelmiddle.add(label2);
        panelbottom.add(button);
        paneltop.setLayout(new FlowLayout(FlowLayout.CENTER,0,  80));
        panelbottom.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        button.setPreferredSize(new Dimension(150, 50)); 
        button.addActionListener(this);
        button.setText("PLAY");
        button.setFocusable(false);
        button.setBackground(Color.blue);
        button.setForeground(Color.white);
        this.setSize(900, 900);
        // this.setLayout(new GridLayout(3, 1, 10, 10));
        this.setLayout(new GridLayout(3, 1));
        this.add(paneltop);
        this.add(panelmiddle);
        this.add(panelbottom);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            Window w = new Window();
            w.start();
        }
    }
}
