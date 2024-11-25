package CloudGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener{
    private Window w;

    public KeyboardHandler(Window w){
        this.w = w;
        w.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    private boolean movingleft = false;
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_D){
            w.player.velx = w.player.speed;
            movingleft = false;
        }
        if(key==KeyEvent.VK_A){
            w.player.velx = -w.player.speed;
            movingleft = true;
        }
        if(key==KeyEvent.VK_W){
            if(w.player.vely == 0){
                w.player.vely = -w.player.jumpVelocity;
            }
        }
        // if(key==KeyEvent.VK_S){
        //     w.player.vely = w.player.speed;
        //     movingdown = true;
        // }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_D && !movingleft){
            w.player.velx = 0;
        }
        if(key==KeyEvent.VK_A && movingleft){
            w.player.velx = 0;
        }
        // if(key==KeyEvent.VK_W && !movingdown){
        //     w.player.vely = 0;
        // }
        // if(key==KeyEvent.VK_S && movingdown){
        //     w.player.vely = 0;
        // }
    }
}


//week 1 to week 12
//3 questions given. You have to write 2/3. Do it within the time complexity
