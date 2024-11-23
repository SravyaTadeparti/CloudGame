package CloudGame;
import javax.swing.ImageIcon;
import javax.swing.JFrame ;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MyFrame extends JFrame{

    // JButton button;
    MyFrame(){

        // button = new JButton();
        // button.setBounds(0, 0, 50, 50);
        // button.addActionListener(this);
        // button.setText("Hello");

        this.setTitle("Testing window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
        //this.setSize(420, 420);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("game_icon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.pink);

        // this.add(button);
    }

    // @Override
    // public void actionPerformed(ActionEvent e){
    //     if(e.getSource()==button){
    //         System.out.println("Hi");
    //         MyFrame newframe = new MyFrame();

    //     }
    // }
}
