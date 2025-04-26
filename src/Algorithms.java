import java.util.*;

public class Algorithms {
    // UCS function to find the goal city from the current_city using
    // the weight of the graph to get an optimal solution.
    // It starts exploring using the city that has the lowest edge-weight (cost).

   public static Pair<List<String>, List<String>> ucs(Graph graph, String start, String goal) {
       PriorityQueue<Node> pq = new PriorityQueue<>();
       pq.add(new Node(0, start, new ArrayList<>(List.of(start))));
       Set<String> visited = new HashSet<>();
       List<String> orderVisited = new ArrayList<>();

       while (!pq.isEmpty()) {
           Node current = pq.remove();
           int pathCost = current.cost;
           String currentCity = current.city;
           List<String> path = current.path;

           if (currentCity.equals(goal))
               return new Pair<>(path, orderVisited);

           if (!visited.contains(currentCity)){
               visited.add(currentCity);
               orderVisited.add(currentCity);

               // Get neighbors of the current city
               List<Edge> neighbors = new ArrayList<>(graph.getNeighbors(currentCity));

               for (Edge neighbor : neighbors) {
                   if (!visited.contains(neighbor.city)){
                       int newCost = pathCost + neighbor.cost;
                       List<String> newPath = new ArrayList<>(path);
                       newPath.add(neighbor.city);
                       pq.add(new Node(newCost, neighbor.city, newPath));
                   }
               }
           }
       }
       return null;
   }
}

class Pair<F, S>{
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}

class Node implements Comparable<Node> {
    int cost;
    String city;
    List<String> path = new ArrayList<>();

    public Node(int cost, String city, List<String> path) {
        this.cost = cost;
        this.city = city;
        this.path = path;
    }

    @Override
    public int compareTo(Node other){
        return this.cost - other.cost;
    }
}
