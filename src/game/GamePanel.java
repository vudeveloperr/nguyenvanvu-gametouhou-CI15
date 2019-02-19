package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    Player player;

    public GamePanel(){
        background = new Background();
        player = new Player();
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
        player.render(g);

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
        player.run();


    }





}

