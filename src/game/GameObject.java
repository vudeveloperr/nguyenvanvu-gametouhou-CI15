package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static : quanli doi tuong
    public static ArrayList<GameObject> objects = new ArrayList<>();

    //Nhiem vu: Tra ra 1 gameObject
    //1.tim trong object, neu co phan tu thoa man > reset phan tu do
    //roi tra ra
    // 2.neu ko tim thay phan tu thoa man thi tao moi roi tra ra
    //recycle

    public <E extends GameObject > E recycle(Class<E> cls){

        return null;
    }

    // non-static dinh nghia doi tuong
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;

    public GameObject(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.active = true;
        objects.add(this);

    }

    public void render(Graphics g){
        g.drawImage(this.image,(int)this.position.x,(int)position.y,null);
    }

    public void run(){
        this.position.add(this.velocity.x,this.velocity.y);
    }

    public void deactive(){
        this.active = false;
    }

    public void reset(){
        this.active = true;
    }

}