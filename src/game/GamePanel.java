package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    BufferedImage playerImage;
    Vector2D playerPosition;
    BufferedImage bulletImage;
//    Vector2D[] bulletPositions;
    ArrayList<Vector2D> bulletPositions;
    int fireCount;

    public GamePanel(){
        background = new Background();
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        playerPosition = new Vector2D(200,500);
        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletPositions = new ArrayList<>();
        bulletPositions.add(new Vector2D(200,400));
        fireCount =0;
        //bulletPositions.add() //them phan tu vao mang
//        bulletPositions.get()// lay ra phan tu o vitri cu the
//        bulletPositions.size()// lay ra kich thuoc cua mang
    }

    @Override
    public void paint(Graphics g) {
        //load image
       // BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");

        // draw image
        background.render(g);

        g.drawImage(playerImage, (int) playerPosition.x, (int) playerPosition.y, null);

        for (int i =0 ; i<bulletPositions.size();i++){
            Vector2D bulletPosition = bulletPositions.get(i);
            g.drawImage(bulletImage,(int)bulletPosition.x,(int)bulletPosition.y,null);
        }
    }



    public void gameloop(){
        long lasttime = 0 ;
        long delay = 1000/80 ;
        while(true){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lasttime >= delay){
                //ve anh + chay logic
                //System.out.println(currentTime - lasttime); thoi gian delay
                runAll();
                renderAll();
                lasttime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }



    private void runAll() {
        background.run();
        playerRun();
        bulletsRun();

    }

    private void bulletsRun() {
        for (int i = 0; i< bulletPositions.size(); i++){
            Vector2D bulletPosition= bulletPositions.get(i);
            bulletPosition.y -=3 ;
        }
    }

    private void playerRun() {
        playerMove();
        playerlimit();
        playerFire();

    }

    private void playerFire() {
        fireCount++;
        if (GameWindow.isFirePress && fireCount > 20){
            Vector2D bulletPosition =  new Vector2D(playerPosition.x ,playerPosition.y);
            bulletPositions.add(bulletPosition);
            fireCount =0;
        }
    }

    private void playerlimit() {
        if (playerPosition.y < 0) {// limit player
            playerPosition.y = 0;
        }
        if (playerPosition.y > 600-48) {
            playerPosition.y = 600-48;
        }
        if (playerPosition.x < 0) {
            playerPosition.x = 0;
        }
        if (playerPosition.x > 384-32) {
            playerPosition.x = 384-32;
        }


    }

    private void playerMove() {
        if (GameWindow.isUpPress ) {
            playerPosition.y--;
        }
        if (GameWindow.isDownPress ) {
            playerPosition.y++;
        }
        if (GameWindow.isLeftPress ) {
            playerPosition.x--;
        }
        if (GameWindow.isRightPress ) {
            playerPosition.x++;
        }
    }




}

