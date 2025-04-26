import java.awt.*;
import javax.swing.*;
public class SwingApp extends Canvas {

    // A JFrame is Swing's implementation of a "window"
    private JFrame frame = new JFrame("Window Title");
    private int width = 512;
    private int height = 512;

    private boolean colorFlip = true;



    SwingApp() {

        // Set fixed, non-resizable dimensions
        frame.setSize(width, height);
        frame.setResizable(false);

        // Make it so that the whole program quits when we kill the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add this object (inherited class type canvas) to the window
        //   - Adding a drawable canvas to our window
        frame.getContentPane().add( this );

        // Begin rendering the window
        frame.setVisible(true);

        run();
    }

    public void run() {

        long nextDrawTime = 0;

        while (true) {
            long currTime = System.currentTimeMillis();
            if (currTime > nextDrawTime) {
                nextDrawTime = currTime + 1000;
                this.paint(this.getGraphics());
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        colorFlip = !colorFlip;

        if (colorFlip)
            g.setColor(Color.black);
        else
            g.setColor(Color.red);

        g.fillRect(0, 0, width, height);

        g.setColor(Color.white);
        int boxWidth = width/8;
        int boxHeight = height/8;

        boolean alternate = true;
        for(int i=0; i < 8; i++) {
            for(int j=0; j < 8; j++) {
                alternate = !alternate;
                if (alternate) {
                    g.fillRect(j*boxWidth, i*boxHeight, boxWidth, boxHeight);
                }
            }
            alternate = !alternate;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        SwingApp app = new SwingApp();
    }
}
