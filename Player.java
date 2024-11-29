// // 

// package CloudGame;

// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Rectangle;

// public class Player {
//     public Window w;
//     public double x, y;
//     public int width, height;
//     public double velx, vely;
//     public int speed = 4;
//     public double jumpVelocity = -6; // Negative to simulate upward velocity

//     public boolean onGround = false; // Track if the player is on the ground

//     public Player(Window w, int x, int y, int width, int height){
//         this.w = w;
//         this.x = x;
//         this.y = y;
//         this.width = width;
//         this.height = height;
//     }

//     public void tick(){
//         // Update horizontal position based on velocity
//         x += velx;

//         // Gravity logic: increase vertical velocity if not on ground
//         if(!onGround) {
//             if(vely < 10) vely += 0.1; // Gravity
//         } else {
//             vely = 0; // Reset vertical velocity if on the ground
//         }

//         // Update vertical position
//         if(y + vely < 500) {  // Assuming 500 is the ground level
//             y += vely;
//         } else {
//             y = 500;  // Keep player at the ground level
//             onGround = true;
//         }
//     }

//     public void jump() {
//         if (onGround) {
//             vely = jumpVelocity;  // Apply the jump velocity
//             onGround = false; // Player is no longer on the ground
//         }
//     }

//     public void moveLeft() {
//         velx = -speed;  // Move left
//     }

//     public void moveRight() {
//         velx = speed;  // Move right
//     }

//     public void stopMoving() {
//         velx = 0;  // Stop horizontal movement when no key is pressed
//     }

//     public void Render(Graphics g){
//         g.setColor(Color.black);
//         g.fillRect((int)x, (int)y, width, height);
//     }

//     public Rectangle getBounds() {
//         return new Rectangle((int) x, (int) y, width, height);
//     }
//     public void setOnGround(boolean onGround) {
//         this.onGround = onGround;
//     }
        
// }

package CloudGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {
    public Window w;
    public double x, y;
    public int width, height;
    public double velx, vely;
    public int speed = 6;
    public double jumpVelocity = 3;
    public boolean onCloud = false;
    public boolean onGround = false;
    private Image playerImage;
    public int points;

    public Player(Window w, int x, int y, int width, int height, int points) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playerImage = new ImageIcon("girl.png").getImage();
        this.points = points;
    }

    public void tick() {
        x += velx;

        if (vely < 30) { 
            vely += 0.1; 
        }

        if (y + vely < 850) {
            y += vely;
        } else {
            vely = 0;
        }

        for (Cloud cloud : w.clouds) {
            if (getBounds().intersects(cloud.getBounds())) {
                if (vely > 0 && getBounds().intersects(cloud.getBounds())) {
                    y = cloud.y - height;
                    vely = 0;  
                    if(!cloud.jumped){
                        points++;
                        cloud.jumped = true;
                        cloud.cloudImage = cloud.cloud2;
                        System.out.println("Points:" + points);
                    }
                }
                else {
                    y += vely;
                }
            }
        }
    }



    public void Render(Graphics g) {
        g.setColor(Color.black);
        // g.fillRect((int) x, (int) y, width, height);
        g.drawImage(playerImage, (int) x, (int) y, width, height, null);
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public java.awt.Rectangle getBounds() {
   
        return new java.awt.Rectangle((int) x, (int) y, width, height);
    }
}
