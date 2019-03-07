package game.player;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Player extends GameObject {
    int fireCount;
    int bulletType;
    int changeBulletCount;
    Random random;

    public Player(){

        renderer = new AnimationRenderer("assets/images/players/straight",10);
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

    private void playerMove() {
        int vX = 0;
        int vY = 0;

        if (GameWindow.isUpPress ) {
            vY-=3;
            renderer = new AnimationRenderer("assets/images/players/straight",10);
        }
        if (GameWindow.isDownPress ) {
            vY+=3;
            renderer = new AnimationRenderer("assets/images/players/straight",10);
        }
        if (GameWindow.isLeftPress ) {
            vX-=3;
            renderer = new AnimationRenderer("assets/images/players/left",10);
        }
        if (GameWindow.isRightPress ) {
            vX+=3;
            renderer = new AnimationRenderer("assets/images/players/right",10);
        }

        this.velocity.set(vX,vY);
        this.velocity.setLength(3);
    }

    private void playerlimit() {
        double offsetWidth = anchor.x * Settings.PLAYER_WIDTH;
        double offsetHeight = anchor.y * Settings.PLAYER_HEIGHT;

        if (position.y < offsetHeight) {// limit player
            position.y = offsetHeight;
        }
        if (position.y > Settings.GAME_HEIGHT - offsetHeight ) {
            position.y = Settings.GAME_HEIGHT - offsetHeight ;
        }
        if (position.x < offsetWidth) {
            position.x = offsetWidth;
        }
        if (position.x > Settings.BACKGROUND_WIDTH - offsetWidth) {
            position.x = Settings.BACKGROUND_WIDTH - offsetWidth;
        }
    }

    private void playerFire() {
        fireCount+=2;
        if (GameWindow.isFirePress && fireCount > Settings.DURATION_FIRE_BULLET){
            for (int i = 0; i < 1; i++) {
                //PlayerBullet bullet = new PlayerBullet();
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                //bullet.loadImageByType(bulletType);
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
        if (changeBulletCount > Settings.DURATION_CHANGE_BULLET_TYPE){
            bulletType = 1 + random.nextInt(3) ;
            changeBulletCount = 0;
        }
    }







}
