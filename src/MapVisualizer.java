import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MapVisualizer {
    public static void main(String[] args) {

        JFrame frame = new JFrame("North American Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.add(new MapPanel());
        frame.setVisible(true);
    }
}

class MapPanel extends JPanel {
    private Image usMapImage;
    private Map<String, Point> cities;

    public MapPanel() {
        // Load the background US map image
        usMapImage = new ImageIcon("src/map.png").getImage();

        // City coordinates
        cities = new HashMap<>();

        cities.put("San Francisco", new Point(120, 380));
        cities.put("Los Angeles", new Point(130, 470));
        cities.put("Las Vegas", new Point(170, 420));
        cities.put("Salt Lake City", new Point(230, 340));
        cities.put("Denver", new Point(350, 340));
        cities.put("Santa Fe", new Point(350, 420));
        cities.put("El Paso", new Point(380, 500));
        cities.put("Phoenix", new Point(250, 480));
        cities.put("Dallas", new Point(500, 490));
        cities.put("Houston", new Point(540, 540));
        cities.put("Chicago", new Point(630, 230));
        cities.put("St. Louis", new Point(550, 320));
        cities.put("Atlanta", new Point(690, 440));
        cities.put("New York", new Point(890, 190));
        cities.put("Washington", new Point(850, 260));
        cities.put("Miami", new Point(850, 520));
        cities.put("Seattle", new Point(110, 160));
        cities.put("Portland", new Point(100, 210));
        cities.put("Kansas City", new Point(470, 310));
        cities.put("Omaha", new Point(470, 240));
        cities.put("Helena", new Point(270, 150));
        cities.put("Boston", new Point(950, 150));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the US map background
        g.drawImage(usMapImage, 0, 0, getWidth(), getHeight(), this);

        // Draw cities as red dots
        g.setColor(Color.RED);
        for (Map.Entry<String, Point> entry : cities.entrySet()) {
            Point p = entry.getValue();
            g.fillOval(p.x - 5, p.y - 5, 10, 10);
            g.drawString(entry.getKey(), p.x + 8, p.y);
        }

        // Draw a path
        //g.setColor(Color.BLUE);
        //drawPath(g, "San Francisco", "Denver");
        //drawPath(g, "Denver", "Chicago");
        //drawPath(g, "Chicago", "New York");
    }

    private void drawPath(Graphics g, String city1, String city2) {
        Point p1 = cities.get(city1);
        Point p2 = cities.get(city2);
        if(p1 != null && p2 != null) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }



}
