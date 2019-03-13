package game.enemy;

import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import game.player.Player;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    int damage;

    //static BufferedImage image1 = SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png");

    public EnemyBullet(){
        //position.set(15,15);
        velocity.set(0,4);
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        collider = new BoxCollider(this , 10,10);
        damage = 1;
    }

    @Override
    public void run(){
        super.run();
        this.deactiveIfNeeded();
        this.checkIntersect();
    }

    private void checkIntersect() {
        Player player = GameObject.findIntersects(Player.class , this.collider);
        if (player != null){
            player.takeDamage(this.damage);
            this.deactive();
        }
    }

    private void deactiveIfNeeded() {
        if (this.position.x < -10 ||this.position.x >= Settings.BACKGROUND_WIDTH -9 ||this.position.y< -30 || this.position.y > Settings.GAME_HEIGHT){
            this.deactive();
        }
    }

}
