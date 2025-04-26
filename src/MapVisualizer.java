import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapVisualizer {
    public static void createAndShowMap(Graph graph) {
        JFrame frame = new JFrame("North American Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1060, 700);
        frame.add(new MapPanel(graph));
        frame.setVisible(true);
    }
}


class MapPanel extends JPanel {
    private Image usMapImage;
    private Graph graph;
    private String startCity = null;
    private String goalCity = null;
    private List<String> pathToHighlight = new ArrayList<>();
    private List<String> orderVisited = new ArrayList<>();

    public MapPanel(Graph graph) {
        this.graph = graph;
        usMapImage = new ImageIcon("src/mmap.png").getImage();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getPoint());
            }
        });
    }

    public void setPathToHighlight(List<String> path, List<String> orderVisited) {
        this.pathToHighlight = path;
        this.orderVisited = orderVisited;
        repaint();
    }

    private void handleMouseClick(Point clickPoint) {
        String clickedCity = findCity(clickPoint);

        if (clickedCity != null) {
            if (startCity == null) {
                startCity = clickedCity;
                System.out.println("Start city selected: " + startCity);
            } else if (goalCity == null) {
                goalCity = clickedCity;
                System.out.println("Goal city selected: " + goalCity);


                Pair<List<String>, List<String>> result = Algorithms.ucs(graph, startCity, goalCity);
                if (result != null) {
                    List<String> path = result.getFirst();
                    List<String> orderVisited = result.getSecond();
                    setPathToHighlight(path, orderVisited);
                } else {
                    System.out.println("No path found.");
                }

                // After path found, reset
                startCity = null;
                goalCity = null;
            }
        }
    }

    private String findCity(Point clickPoint) {
        for (Map.Entry<String, Point> entry : graph.cityCoordinates.entrySet()) {
            Point cityPos = entry.getValue();
            double distance = clickPoint.distance(cityPos);
            if (distance <= 10) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the US map background
        g.drawImage(usMapImage, 0, 0, getWidth(), getHeight(), this);

        // Draw Edges
        g.setColor(Color.GRAY);
        for (String city : graph.getCities()){
            Point p1 = graph.cityCoordinates.get(city);
            for (Edge edge : graph.getNeighbors(city)) {
                Point p2 = graph.cityCoordinates.get(edge.city);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // Draw cities
        g.setColor(Color.RED);
        for (Map.Entry<String, Point> entry : graph.cityCoordinates.entrySet()) {
            Point p = entry.getValue();
            g.fillOval(p.x - 5, p.y - 5, 10, 10);
            g.drawString(entry.getKey(), p.x + 8, p.y);
        }

        // Highlight the path
        if (pathToHighlight != null && pathToHighlight.size() >= 2) {
            g.setColor(Color.BLUE);
            for (int i = 0; i < pathToHighlight.size() - 1; i++) {
                Point from = graph.cityCoordinates.get(pathToHighlight.get(i));
                Point to = graph.cityCoordinates.get(pathToHighlight.get(i+1));
                g.drawLine(from.x, from.y, to.x, to.y);
            }
        }

        // Highlight the path
        if (orderVisited != null && orderVisited.size() >= 2) {
            g.setColor(Color.YELLOW);
            for (int i = 0; i < orderVisited.size() - 1; i++) {
                Point from = graph.cityCoordinates.get(orderVisited.get(i));
                Point to = graph.cityCoordinates.get(orderVisited.get(i+1));
                g.drawLine(from.x, from.y, to.x, to.y);
            }
        }
    }

}