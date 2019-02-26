package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    Vector2D position;
//    BufferedImage bulletImage;
//    //    Vector2D[] bulletPositions;
//    ArrayList<Vector2D> bulletPositions;
    ArrayList<PlayerBullet> bullets;
    int fireCount;

    BufferedImage bulletType2Image;

//            bulletPositions.add() //them phan tu vao mang
//            bulletPositions.get()// lay ra phan tu o vitri cu the
//            bulletPositions.size()// lay ra kich thuoc cua mang
    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/3.png");
        position = new Vector2D(200,500);
//        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
        bullets = new ArrayList<>();

        //bulletPositions.add(new Vector2D(200,400));
        fireCount =0;
        bulletType2Image = SpriteUtils.loadImage("assets/images/sphere/0.png");
    }

    public void render(Graphics g){
        g.drawImage(image, (int) position.x, (int) position.y, null);
        g.drawImage(bulletType2Image, (int) position.x, (int)position.y , null);

//        for (int i =0 ; i<bulletPositions.size();i++){
//            Vector2D bulletPosition = bulletPositions.get(i);
//            g.drawImage(bulletImage,(int)bulletPosition.x,(int)bulletPosition.y,null);
//        }


        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    private void bulletsRun() {

//        for (int i = 0; i< bulletPositions.size(); i++){
//            Vector2D bulletPosition= bulletPositions.get(i);
//            bulletPosition.y -=3 ;
//        }

        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.run();
        }
    }

    public void run() {
        playerMove();
        playerlimit();
        playerFire();
        bulletsRun();
    }

    private void playerFire() {
        fireCount+=4;
        if (GameWindow.isFirePress && fireCount > 20){
//            Vector2D bulletPosition =  new Vector2D(position.x , position.y);
//            bulletPositions.add(bulletPosition);

            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(-Math.PI * 0.5);
            bullets.add(bullet);

            PlayerBullet bullet2 = new PlayerBullet();
            bullet2.image = bulletType2Image;
            bullet2.position.set(this.position.x , this.position.y);
            bullet2.velocity.setAngle(-Math.PI * 0.45);
            bullets.add(bullet2);

            PlayerBullet bullet3 = new PlayerBullet();
            bullet3.image = bulletType2Image;
            bullet3.position.set(this.position.x , this.position.y);
            bullet3.velocity.setAngle(-Math.PI * 0.55);
            bullets.add(bullet3);

            fireCount =0;
        }
    }

    private void playerlimit() {
        if (position.y < 0) {// limit player
            position.y = 0;
        }
        if (position.y > 600-48) {
            position.y = 600-48;
        }
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > 384-32) {
            position.x = 384-32;
        }


    }

    private void playerMove() {
        if (GameWindow.isUpPress ) {
            position.y-=3;
        }
        if (GameWindow.isDownPress ) {
            position.y+=3;
        }
        if (GameWindow.isLeftPress ) {
            position.x-=3;
        }
        if (GameWindow.isRightPress ) {
            position.x+=3;
        }
    }



}
