import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.SplittableRandom;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        window.makeWindow();
        window.makeVisible();
        SplittableRandom rand = new SplittableRandom();
        window.clearArr(window.arr.size());
        for(int i=0; i<Math.pow(10, 4)*4 ; i++){
            window.addVal(rand.nextDouble()*250000);

            //window.pn.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            }catch(InterruptedException ignored){}
        }
        while(!window.keyPressed()){System.out.println(window.keyPressed());}
        window.init = false;
        System.out.println("aAA");
        Sorts.screen = window;
        Sorts.bubblesort(window.arr);
        System.out.println("a");
        window.pn.repaint();
        while(!window.keyPressed()){System.out.println(window.keyPressed());}

        //2
        window.clearArr(window.arr.size());
        for(int i=0; i<Math.pow(10, 5)*1; i++){
            window.addVal(rand.nextDouble()*25000);

            //window.pn.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            }catch(InterruptedException ignored){}
        }
        window.pn.repaint();
        while(!window.keyPressed()){System.out.println(window.keyPressed());}
        window.init = false;
        System.out.println("aAA");
        Sorts.screen = window;
        Sorts.selectionsort(window.arr);
        System.out.println("a");
        window.pn.repaint();
        while(!window.keyPressed()){System.out.println(window.keyPressed());}


        //3

        window.clearArr(window.arr.size());
        for(int i=0; i<Math.pow(10, 5)*1; i++){
            window.addVal(rand.nextDouble()*25000);

            //window.pn.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            }catch(InterruptedException ignored){}
        }
        window.pn.repaint();
        while(!window.keyPressed()){System.out.println(window.keyPressed());}
        window.init = false;
        System.out.println("aAA");
        Sorts.screen = window;
        Sorts.insertionsort(window.arr);
        System.out.println("a");
        window.pn.repaint();

    }

}