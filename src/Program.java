import game.GameWindow;
import game.GamePanel;
import game.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
//    public static double[] equation2(double a , double b, double c) {
//        double[] result = new double[2];
//        double d;
//        double x1 ,  x2 ,  y;
//        d = b*b - (4*a*c);
//        if (d<0){
//            System.out.println("vo nghiem!!");
//            result = null;
//        }
//        else if (d==0){
//            y = -b/2*a;
//            System.out.println(y);
//        }
//        else {
//            double s = Math.sqrt(d);
//            x1 = (-b+s)/(2*a);
//            x2 = (-b-s)/(2*a);
//            System.out.println(x1);
//            System.out.println(x2);
//        }
//
//        return result;
//    }
/*
*   if(a==0){
*       if(b==0){
*       }
*       else{
*       }
*   }
*   else
*   {
*       result
*   }
*
* */
    public static void main(String[] args) {
//        double[] result = equation2(1,2,3);
//        if (result == null){
//            System.out.println("vo nghiem ");
//        }
//        else{
//            System.out.println("x1 : " + result[0]);
//            System.out.println("x2 : "+ result[1]);
//        }


        GameWindow window = new GameWindow();
       // window.setSize(800, 600); // tao kich thuoc
        window.setResizable(false); // co dinh kich thuoc
        window.setTitle("Game Touhou");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800 , 600));
        window.add(panel);
        window.pack();
        panel.setBackground(Color.YELLOW);

        window.setVisible(true);
        panel.gameloop();
    }
        //biến , hàm
//        try {
//            devide(10,0)
//        } catch(Exception exception){
//            //System.out.println(exception.getMessage());
//            exception.printStackTrace();
//        }
//        System.out.println("he");
//    }
//
//    private static double devide(int x, int y) {
//        return x/y;
//    }

//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        vectors.add(new Vector2D(1, 2));
//        vectors.add(new Vector2D(2, 2));
//        vectors.add(new Vector2D(3, 3));
//        vectors.add(new Vector2D(4, 1));
//
////        for (int i = 0; i < vectors.size(); i++) {
////            Vector2D vector = vectors.get(i);
////            System.out.println(vector.x + " " + vector.y);
////        }
//// todo : tim vector co tong lon nhat
//        double max = 0;
//        int maxIndex = 0;
//        for (int i = 0; i < vectors.size(); i++) {
//            Vector2D vector = vectors.get(i);
//            if (vector.x + vector.y > max) {
//                max = vector.x + vector.y;
//                maxIndex = i;
//            }
//        }
//        Vector2D vectorMax = vectors.get(maxIndex);
//        System.out.println(vectorMax.x + " " + vectorMax.y);
//
//
//
//    }

}
