import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;


public class Graph {
    private Map<String, List<Edge>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addEdge(String city1, String city2, int cost) {
        graph.computeIfAbsent(city1, k -> new ArrayList<>()).add(new Edge(city2, cost));
        graph.computeIfAbsent(city2, k -> new ArrayList<>()).add(new Edge(city1, cost));
    }

    public List<Edge> getNeighbors(String city) {
        return graph.getOrDefault(city, new ArrayList<>());
    }

    public Set<String> getCities() {
        return graph.keySet();
    }
}

class Edge {
    public String city;
    public int cost;

    public Edge(String city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}
