import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.SplittableRandom;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        window.makeWindow();
        window.makeVisible();
        SplittableRandom rand = new SplittableRandom();
        window.clearArr(window.arr.size());
		int c = 0;
        for(int i=0; i<Math.pow(10, 2)*1 ; i++){
            window.addVal(rand.nextInt(25));

            //window.pn.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(0);
            }catch(InterruptedException ignored){}
        }
        while(!window.keyPressed()){
			System.out.println(window.keyPressed() + "" + c++);
			try{
				TimeUnit.MILLISECONDS.sleep(0);
			}catch(InterruptedException ignored){}


		}
        window.init = false;
        System.out.println("aAA");
        Sorts.screen = window;

        Sorts.quickSort(window.arr);

        System.out.println("a");
        window.pn.repaint();
        window.keyPressed = false;
		System.out.println(window.arr);
        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }catch(InterruptedException ignored){}
        window.init = true;
        window.pn.repaint();
        //while(!window.keyPressed()){System.out.println(window.keyPressed());}
        //2
        /*
        window.clearArr(window.arr.size());
        for(int i=0; i<Math.pow(10, 3)*1; i++){
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
        window.keyPressed = false;
        while(!window.keyPressed()){System.out.println(window.keyPressed());}


        //3

        window.clearArr(window.arr.size());
        for(int i=0; i<Math.pow(10, 5)*7; i++){
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
        window.pn.repaint();*/
    }

}
