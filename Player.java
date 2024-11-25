package CloudGame;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    public Window w;
    public double x, y;
    public int width, height;
    public double velx, vely;
    public int speed = 4;
    public double jumpVelocity = 6;

    public Player(Window w, int x, int y, int width, int height){
        this.w = w;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void tick(){
        x+=velx;
        if(vely>-w.level.Gravity){
            vely+=0.1;
        }
        if(y+vely<500){
            y+=vely;
        }
        else{
            vely = 0;
        }
    }
    public void Render(Graphics g){
        g.setColor(Color.black);
        g.fillRect((int)x, (int)y, width, height);
    }
}
