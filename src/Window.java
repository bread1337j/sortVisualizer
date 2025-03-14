
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
    public List<Double> arrcache = new ArrayList<>();
    int size = 0;
    public int pointer;
    int pointercache;
    double max = 0.01;
    public boolean keyPressed = false;
    public boolean init = true;
    public Window(){}
    SplittableRandom rand = new SplittableRandom();
    JPanel pn = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            double width = (double) getWidth() / (double) size;
            if(init) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
                g2d.setColor(new Color(0, 0, 0));


                if (size > 0) {

                    for (int i = 0; i < arr.size(); i++) {
                        Rectangle2D rect = new Rectangle2D.Double(i * width, getHeight() - getHeight() * arr.get(i) / max, width, getHeight() * arr.get(i) / max);
                        g2d.fill(rect);
                    }
                }
                //init = false;
            }else{
                if (size > 0) {


                    for (int i = 0; i < arr.size(); i++) {
                        if(arrcache.size()<arr.size()){syncArr();}
                        if(arrcache.get(i) != arr.get(i) || i==pointercache) {
                            g2d.setColor(Color.WHITE);
                            Rectangle2D clear = new Rectangle2D.Double(i*width, 0, width, getHeight());
                            g2d.fill(clear);
                            g2d.setColor(Color.BLACK);
                            Rectangle2D rect = new Rectangle2D.Double(i * width, getHeight() - getHeight() * arr.get(i) / max, width, getHeight() * arr.get(i) / max);
                            g2d.fill(rect);


                        }
                    }
                    if(pointer > 0 && pointer < arr.size()) {//pointer can be disabled by setting to -1
                        g2d.setColor(Color.RED);
                        Rectangle2D cursor = new Rectangle2D.Double(pointer * width, 0, width, getHeight());
                        g2d.fill(cursor);
                        pointercache = pointer;
                    }
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
    public void syncArr(){
        arrcache = new ArrayList<>(arr);
    }
    public void clearArr(int n){
        arr = new ArrayList<>(n);
        size = 0;
        max = 0.01;
        init = true;
        keyPressed = false;
    }

}