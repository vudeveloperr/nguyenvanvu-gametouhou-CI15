package game.enemy;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    static BufferedImage image1 = SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png");

    public EnemyBullet(){
        //position.set(15,15);
        velocity.set(0,4);

        //velocity.setAngle(Math.PI/18);
    }

    @Override
    public void run(){
        super.run();
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (this.position.x < -10 ||this.position.x >= Settings.BACKGROUND_WIDTH -9 ||this.position.y< -30 || this.position.y > Settings.GAME_HEIGHT){
            this.deactive();
        }
    }

    public void loadImage(){
        this.image = image1;
    }

}
