package game;

import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    static BufferedImage image1 = SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png");

    public EnemyBullet(){
        position.set(15,15);
        velocity.set(1,1);
        velocity.setLength(2);
        //velocity.setAngle(Math.PI/18);
    }
    public void loadImage(){
        this.image = image1;
    }

}
