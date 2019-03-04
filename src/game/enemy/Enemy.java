package game.enemy;

import game.*;
import game.player.Player;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    int fireCount ;

    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.set(-50 , -50);
        velocity.set(2,2);
        velocity.setAngle(Math.PI /18);
        velocity.setLength(Settings.ENERMY_SPEED);
        fireCount = 0;
    }

//    public void render(Graphics g){
//        g.drawImage(image, (int)position.x, (int)position.y,null);
//    }
    @Override
    public void run(){
        super.run();
        changeVelocity();
        enemyFire();

    }

    private void enemyFire() {
        fireCount++;
        if (fireCount>10) {
                // tao ta vien dan
                //EnemyBullet bullet1 = new EnemyBullet();
                EnemyBullet bullet1 = GameObject.recycle(EnemyBullet.class);
                bullet1.loadImage();
                bullet1.position.set(this.position);

                //bullet1.velocity.setAngle(Math.PI * 0.5);

                //2 . tinh toan vector tro tu enemy den player
                Player player = GameObject.find(Player.class);
                Vector2D enemyToPlayer = player.position.clone();
                enemyToPlayer.minus(this.position);
                enemyToPlayer.setLength(4);

                // dat bullet velocuty = vector vua tinh toan
                bullet1.velocity.set(enemyToPlayer.x,enemyToPlayer.y);


//                EnemyBullet bullet2 = new EnemyBullet();
//                bullet2.loadImage();
//                bullet2.position.set(this.position.x, this.position.y);
//                bullet2.velocity.setAngle(Math.PI * 0.6);
//
//                EnemyBullet bullet3 = new EnemyBullet();
//                bullet3.loadImage();
//                bullet3.position.set(this.position.x, this.position.y);
//                bullet3.velocity.setAngle(Math.PI * 0.7);
//
//                EnemyBullet bullet4 = new EnemyBullet();
//                bullet4.loadImage();
//                bullet4.position.set(this.position.x, this.position.y);
//                bullet4.velocity.setAngle(Math.PI * 0.8);
//
//                EnemyBullet bullet5 = new EnemyBullet();
//                bullet5.loadImage();
//                bullet5.position.set(this.position.x, this.position.y);
//                bullet5.velocity.setAngle(Math.PI * 0.9);
//
//                EnemyBullet bullet6 = new EnemyBullet();
//                bullet6.loadImage();
//                bullet6.position.set(this.position.x, this.position.y);
//                bullet6.velocity.setAngle(Math.PI * 0);
//
//                EnemyBullet bullet7 = new EnemyBullet();
//                bullet7.loadImage();
//                bullet7.position.set(this.position.x, this.position.y);
//                bullet7.velocity.setAngle(Math.PI * 0.4);
//
//                EnemyBullet bullet8 = new EnemyBullet();
//                bullet8.loadImage();
//                bullet8.position.set(this.position.x, this.position.y);
//                bullet8.velocity.setAngle(Math.PI * 0.3);
//
//                EnemyBullet bullet9 = new EnemyBullet();
//                bullet9.loadImage();
//                bullet9.position.set(this.position.x, this.position.y);
//                bullet9.velocity.setAngle(Math.PI * 0.2);
//
//                EnemyBullet bullet10 = new EnemyBullet();
//                bullet10.loadImage();
//                bullet10.position.set(this.position.x, this.position.y);
//                bullet10.velocity.setAngle(-Math.PI * 0.5);
//
//                EnemyBullet bullet11 = new EnemyBullet();
//                bullet11.loadImage();
//                bullet11.position.set(this.position.x, this.position.y);
//                bullet11.velocity.setAngle(-Math.PI * 0.6);
//
//                EnemyBullet bullet12 = new EnemyBullet();
//                bullet12.loadImage();
//                bullet12.position.set(this.position.x, this.position.y);
//                bullet12.velocity.setAngle(-Math.PI * 0.7);
//
//                EnemyBullet bullet13 = new EnemyBullet();
//                bullet13.loadImage();
//                bullet13.position.set(this.position.x, this.position.y);
//                bullet13.velocity.setAngle(-Math.PI * 0.8);
//
//                EnemyBullet bullet14 = new EnemyBullet();
//                bullet14.loadImage();
//                bullet14.position.set(this.position.x, this.position.y);
//                bullet14.velocity.setAngle(-Math.PI * 0.9);
//
//                EnemyBullet bullet15 = new EnemyBullet();
//                bullet15.loadImage();
//                bullet15.position.set(this.position.x, this.position.y);
//                bullet15.velocity.setAngle(Math.PI );
//
//                EnemyBullet bullet16 = new EnemyBullet();
//                bullet16.loadImage();
//                bullet16.position.set(this.position.x, this.position.y);
//                bullet16.velocity.setAngle(-Math.PI * 0.4);
//
//                EnemyBullet bullet17 = new EnemyBullet();
//                bullet17.loadImage();
//                bullet17.position.set(this.position.x, this.position.y);
//                bullet17.velocity.setAngle(-Math.PI * 0.3);
//
//                EnemyBullet bullet18 = new EnemyBullet();
//                bullet18.loadImage();
//                bullet18.position.set(this.position.x, this.position.y);
//                bullet18.velocity.setAngle(-Math.PI * 0.2);
//
//                EnemyBullet bullet19 = new EnemyBullet();
//                bullet19.loadImage();
//                bullet19.position.set(this.position.x, this.position.y);
//                bullet19.velocity.setAngle(Math.PI * 0.1);
//
//                EnemyBullet bullet20 = new EnemyBullet();
//                bullet20.loadImage();
//                bullet20.position.set(this.position.x, this.position.y);
//                bullet20.velocity.setAngle(-Math.PI * 0.1);
            fireCount = 0;
        }
    }

    private Player findPlayer() {
        Player player = null;
        for (int i = 0; i < GameObject.objects.size() ; i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active && object instanceof Player) {
                player = (Player) object;
            }
        }
        return player;
    }


    private void changeVelocity() {
        if(position.x > Settings.BACKGROUND_WIDTH - Settings.ENERMY_WIDTH && velocity.x>0){
            velocity.set(-velocity.x,velocity.y);
        }
        if (position.x < 0 && velocity.x<0){
            velocity.set(-velocity.x,velocity.y);
        }
        if (position.y > Settings.GAME_HEIGHT - Settings.ENERMY_HEIGHT && velocity.y > 0){
            velocity.set(velocity.x,-velocity.y);
        }
        if (position.y < 0 && velocity.y<0 ){
            velocity.set(velocity.x,-velocity.y);
        }
    }
}
