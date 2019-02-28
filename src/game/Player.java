package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Player extends GameObject{
    int fireCount;
    int bulletType;
    int changeBulletCount;
    Random random;

    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/3.png");
        position.set(200,500);
        fireCount =0;
        bulletType = 1;
        changeBulletCount = 0;
        random = new Random();

    }

    @Override
    public void run() {
        super.run();
        playerMove();
        playerlimit();
        playerFire();
        changeBulletType();
    }


    private void playerFire() {
        fireCount+=4;
        if (GameWindow.isFirePress && fireCount > 20){
            for (int i = 0; i < 1; i++) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.loadImageByType(bulletType);
                bullet.position.set(this.position.x, this.position.y);
                bullet.velocity.setAngle(-Math.PI * 0.5);
            }
//            PlayerBullet bullet2 = new PlayerBullet(bulletType);
//            bullet2.position.set(this.position.x , this.position.y);
//            bullet2.velocity.setAngle(-Math.PI * 0.45);
//            bullets.add(bullet2);
//
//            PlayerBullet bullet3 = new PlayerBullet(bulletType);
//            bullet3.position.set(this.position.x , this.position.y);
//            bullet3.velocity.setAngle(-Math.PI * 0.55);
//            bullets.add(bullet3);

            fireCount =0;
        }
    }
    private void changeBulletType() {
        changeBulletCount ++;
        if (changeBulletCount > 300){
            bulletType = 1 + random.nextInt(3) ;
            changeBulletCount = 0;
        }
    }

    private void playerlimit() {
        if (position.y < 0) {// limit player
            position.y = 0;
        }
        if (position.y > Settings.GAME_HEIGHT-48) {
            position.y = Settings.GAME_HEIGHT-48;
        }
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > Settings.BACKGROUND_WIDTH-32) {
            position.x = Settings.BACKGROUND_WIDTH-32;
        }


    }

    private void playerMove() {
        int vX = 0;
        int vY = 0;

        if (GameWindow.isUpPress ) {
            vY-=3;
        }
        if (GameWindow.isDownPress ) {
            vY+=3;
        }
        if (GameWindow.isLeftPress ) {
            vX-=3;
        }
        if (GameWindow.isRightPress ) {
            vX+=3;
        }

        this.velocity.set(vX,vY);
        this.velocity.setLength(3);
    }



}
