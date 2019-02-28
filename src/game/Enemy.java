package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
    int fireCount ;

    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.set(-50 , -50);
        velocity.set(2,2);
        velocity.setAngle(Math.PI /18);
        velocity.setLength(Settings.ENERMY_SPEED);
        fireCount = 0;
    }

//    public void render(Graphics g){
//        g.drawImage(image, (int)position.x, (int)position.y,null);
//    }
    @Override
    public void run(){
        super.run();
        changeVelocity();
        enemyFire();

    }

    private void enemyFire() {
        fireCount++;
        if (GameWindow.isFirePress && fireCount>10) {
            for (int i = 0; i < 1; i++) {
                EnemyBullet bullet1 = new EnemyBullet();
                bullet1.loadImage();
                bullet1.position.set(this.position.x, this.position.y);
                bullet1.velocity.setAngle(Math.PI * 0.5);
            }
            fireCount = 0;
        }
    }


    private void changeVelocity() {
        if(position.x > Settings.BACKGROUND_WIDTH - Settings.ENERMY_WIDTH && velocity.x>0){
            velocity.set(-velocity.x,velocity.y);
        }
        if (position.x < 0 && velocity.x<0){
            velocity.set(-velocity.x,velocity.y);
        }
        if (position.y > Settings.GAME_HEIGHT - Settings.ENERMY_HEIGHT && velocity.y > 0){
            velocity.set(velocity.x,-velocity.y);
        }
        if (position.y < 0 && velocity.y<0 ){
            velocity.set(velocity.x,-velocity.y);
        }
    }
}
