
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.util.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window extends JPanel {
    public List<Double> arr = new ArrayList<>(); //IT NEEDS TO BE PUBLIC OK THIS IS A VITAL FEATURE
    int size = 0;
    double max = 0.01;
    public boolean keyPressed = false;
    public Window(){}
    SplittableRandom rand = new SplittableRandom();
    JPanel pn = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0,0,0));
            if(size>0) {
                double width = (double)getWidth() / (double)size;

                for(int i=0; i<arr.size(); i++){
                    Rectangle2D rect = new Rectangle2D.Double(i*width, getHeight()-getHeight()*arr.get(i)/max, width,  getHeight()*arr.get(i) / max);
                    g2d.fill(rect);
                }
            }

        }
    };

    JFrame fr = new JFrame();
    public boolean keyPressed(){
        return keyPressed;
    }
    public void makeWindow() {
        fr.setSize(1920,1080);
        fr.setDefaultCloseOperation(3);
        fr.add(pn);
        fr.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                keyPressed = true;
                // Additional actions after key press
                System.out.println("Key pressed: " + e.getKeyChar());
            }
        });
    }
    public void makeVisible(){
        fr.setVisible(true);
    }
    public void makeInvisible(){
        fr.setVisible(false);
    }
    public void addVal(double val){
        size++;
        arr.add(val);
        if(val>max){
            max = val;
        }
    }
    public void clearArr(int n){
        arr = new ArrayList<>();
        size = 0;
    }

}