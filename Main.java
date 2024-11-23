package CloudGame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main implements ActionListener{

    JButton button = new JButton();
    public static void main(String[] args){
        ImageIcon cloud2 = new ImageIcon("image.png");

        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel label = new JLabel();
        label.setText("Want to play?");
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setIcon(cloud2);
        // label.setSize(500, 500);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.red);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        label.setBackground(Color.black);
        label.setOpaque(true);

        JPanel panel1 = new JPanel();

        panel1.setBounds(0, 0, 100, 200);

        MyFrame myframe = new MyFrame();
        myframe.add(panel1);


        Main inst = new Main();
        inst.button.setBounds(0, 0, 200, 50);
        inst.button.addActionListener(inst);
        inst.button.setText("Hello");

        label.add(inst.button);



        // myframe.setLayout(null);
        myframe.add(label);
        myframe.pack();

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.out.println("Hi");
            MyFrame newframe = new MyFrame();
            ImageIcon cloud = new ImageIcon("cloud_clear.png");
            JLabel label2 = new JLabel();
            label2.setIcon(cloud);
            label2.setBackground(Color.black);
            label2.setOpaque(true);
            //label2.setBounds(0, 0, 10, 50);
            newframe.add(label2);
            newframe.pack();
        }
    }
}