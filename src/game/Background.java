package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{


    public Background(){
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.position.set(0 , Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
        this.velocity.set(0, Settings.BACKGROUND_SPEED);
    }

    public void render(Graphics g){
        g.drawImage(image, (int)position.x, (int)position.y, null);
    }

    @Override
    public void run() {
        super.run();// background move
        if (position.y > 0 ) { // background limit
            position.y = 0;
        }
    }
}
