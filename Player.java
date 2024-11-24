package CloudGame;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

    public int x, y, width, height;
    public int velx, vely;
    public int speed = 10;

    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void tick(){
        x+=velx;
        y+=vely;
    }
    public void Render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
