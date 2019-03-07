package game;

import game.Vector2D;

public class Rectangle {
    Vector2D position; // vị trí góc trên bên trái hình chữ nhật ()
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle(int x, int y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public double top(){
        return this.position.y;
    }

    public  double bot(){
        return this.top() + this.height;
    }

    public double left(){
        return this.position.x;
    }

    public double right(){
        return this.left() + this.width;
    }


    /**
     * @param other
     * @return false: nếu 2 hcn khong giao nhau
     */
    public boolean intersects(Rectangle other) {
        // TODO: 1. Triển khai phần code kiểm tra va chạm giữa 2 () ở đây

        // cach 2
        //hcn1 = this , hcn2 = other

        return other.right() >= this.left() && other.left() <= this.right()
                && other.bot() >= this.top() && other.top() <= this.bot();



//        double x1 = this.position.x;
//        double y1 = this.position.y;
//        double x2 = other.position.x;
//        double y2 = other.position.y;
//
//        if ( ((x2>x1 && y2>y1)) || ((x2>x1 && y2 <y1 )) || ((y2>y1 && x1>x2 )) || ((y1>y2 && x1>x2))  ) {
//            if (Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) < Math.sqrt(width*width + height*height)) {
//                return true;
//            }else
//                return false;
//        }
//        else if (((x2>x1) && (y1==y2)) || ((x1<x2) && (y1==y2)) ){
//            if (Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) < width) {
//                return true;
//            }
//            else
//                return false;
//        }
//        else if (((x2==x1) && (y1>y2)) || ((x1==x2) && (y1<y2)))
//            if (Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) < height) {
//                return true;
//            }
//            else
//                return false;
//        else
//            return false;
//



    }






    public static void main(String[] args) {
        // TODO: 2. Chạy hàm main này để test kết quả hàm intersects đã triển khai
        Rectangle rect1 = new Rectangle(0, 0, 100, 100);
        Rectangle rect2 = new Rectangle(50, 50, 100, 100);
        Rectangle rect3 = new Rectangle(200, 200, 100, 100);
        System.out.println(rect1.intersects(rect2) + " " + true);
        System.out.println(rect1.intersects(rect3) + " " + false);
    }
}
