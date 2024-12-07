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
        for(int i=0; i<Math.pow(10, 5); i++){
            window.addVal(rand.nextDouble()*5000);

            //window.pn.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            }catch(InterruptedException ignored){}
        }
        while(!window.keyPressed()){System.out.println(window.keyPressed());}
        System.out.println("aAA");
        Sorts.screen = window;
        Sorts.selectionsort(window.arr);
        System.out.println("a");
        window.pn.repaint();
    }

}