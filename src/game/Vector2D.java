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

        return new Vector2D(this.x,this.y);
    }

    public void  set(double x, double y){
        // gan cap x, y cho vector dc goi
        this.x = x ;
        this.y = y ;
    }

    public void add(double x, double y){
        //cong gia tri x, y vao vector dc goi
        this.x += x ;
        this.y += y ;
    }

    public void minus(double x, double y){
        // tru gia tri x, y vao vector dc goi
        this.x -= x ;
        this.y -= y ;
    }

    public void scale(double rate){
        // nhan gia tri rate vao vector dc goi
        this.x *= rate ;
        this.y *= rate ;
    }

    public double getLength(){
        //double z = Math.hypot(x,y) ;
        return Math.sqrt(this.x * this.x + this.y * this.y);// tra ra do dai cua vector dc goi
    }

    public double setLength(double length){
        //giu nguyen gia tri huong cua vector dc goi , thay doi do dai = do dai truyen vao
        double currentLength = this.getLength();
        if (currentLength != 0){
            this.x = this.x * length / currentLength;
            this.y = this.y * length / currentLength;
        }
        return 0;
    }

    public double getAngle(){
//        double z = Math.hypot(x,y) ;
//        double t = x/z;
//        double c = Math.acos(t);
//        double tanAngle = this.y / this.x;
//        double angle =  Math.atan(tanAngle);
//        return angle;


        return Math.atan(this.y / this.x);// tra ra goc tao giua vector vs truc hoanh(x,y) vs (1,0)
    }

    public void setAngle(double angle){
        // giu nguyen do dai cua vector , quay vector den goc truyen vao
        double length = this.getLength();
        if (length != 0 ){
            this.x = length * Math.cos(angle);
            this.y = length * Math.sin(angle);
        }
    }
    // this dai dien cho doi tuong dc tao ra tu classs

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1,3);


    }
}















