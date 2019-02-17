package game;

import com.sun.xml.internal.bind.v2.TODO;

public class Vector2D {
    public double x;
    public double y;

    // ham tao rong
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;

    }

    // TODO: continue upgrading..

    public Vector2D clone(){//

        return null;
    }

    public void  set(double x, double y){
        // gan cap x, y cho vector dc goi
    }

    public void add(double x, double y){
        //cong gia tri x, y vao vector dc goi
    }

    public void minus(double x, double y){
        // tru gia tri x, y vao vector dc goi
    }

    public void scale(double rate){
        // nhan gia tri rate vao vector dc goi
    }

    public double getLength(){
        return 0;// tra ra do dai cua vector dc goi
    }

    public double setLength(double length){
        //giu nguyen gia tri huong cua vector dc goi , thay doi do dai = do dai truyen vao
        return 0;
    }

    public double getAngle(){
        return 0;// tra ra goc tao giua vector vs truv hoanh
    }

    public void setAngle(double angle){
        // giu nguyen do dai cua vector , quay vector den goc truyen vao
    }
}
