package game;

import game.enemy.Enemy;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    Enemy enemy ;

    public GamePanel(){
        background = new Background();
        player = new Player();
        enemy = new Enemy();

    }

    @Override
    public void paint(Graphics g) {
        //load image
       // BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");

        // draw image
        for (int i =0 ; i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if (object.active){
                object.render(g);
            }
        }

    }



    public void gameloop(){
        long lasttime = 0 ;
        long delay = 1000/65 ;
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
        for (int i =0 ; i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if (object.active){
                object.run();
            }
            System.out.println(GameObject.objects.size());
        }

    }





}

