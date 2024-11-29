package CloudGame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Cloud {
    public double x, y;
    int width, height;
    Image cloudImage;
    public Image cloud2;
    public boolean jumped = false;
    public Cloud(double x, double y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cloudImage = new ImageIcon(getClass().getResource("cloud.png")).getImage();
        this.cloud2 = new ImageIcon(getClass().getResource("cloud2.png")).getImage();
    }
    public void Render(Graphics g){
        g.drawImage(cloudImage, (int)x, (int)y, width, height, null);
    }
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}
