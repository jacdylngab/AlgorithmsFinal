import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("vancouver", "calgary", 100);
        graph.addEdge("vancouver", "seattle", 45);

        graph.addEdge("seattle", "portland", 44);
        graph.addEdge("seattle", "calgary", 118);
        graph.addEdge("seattle", "helena", 189);
        graph.addEdge("seattle", "vancouver", 45);

        graph.addEdge("portland", "seattle", 44);
        graph.addEdge("portland", "sanfrancisco", 151);
        graph.addEdge("portland", "saltlakecity", 175);

        graph.addEdge("sanfrancisco", "losangeles", 100);
        graph.addEdge("sanfrancisco", "portland", 151);
        graph.addEdge("sanfrancisco", "saltlakecity", 156);

        graph.addEdge("losangeles", "sanfrancisco", 100);
        graph.addEdge("losangeles", "lasvegas", 66);
        graph.addEdge("losangeles", "phoenix", 109);
        graph.addEdge("losangeles", "elpaso", 191);

        graph.addEdge("calgary", "vancouver", 100);
        graph.addEdge("calgary", "seattle", 118);
        graph.addEdge("calgary", "helena", 130);
        graph.addEdge("calgary", "winnipeg", 180);

        graph.addEdge("montreal", "boston", 69);
        graph.addEdge("montreal", "newyork", 66);
        graph.addEdge("montreal", "toronto", 115);
        graph.addEdge("montreal", "saultstemarie", 193);

        graph.addEdge("pittsburgh", "toronto", 80);
        graph.addEdge("pittsburgh", "chicago", 81);
        graph.addEdge("pittsburgh", "newyork", 69);
        graph.addEdge("pittsburgh", "washington", 85);

        graph.addEdge("miami", "charleston", 80);
        graph.addEdge("miami", "atlanta", 116);
        graph.addEdge("miami", "neworleans", 151);

        graph.addEdge("newyork", "boston", 74);
        graph.addEdge("newyork", "montreal", 66);
        graph.addEdge("newyork", "washington", 76);
        graph.addEdge("newyork", "pittsburgh", 69);

        graph.addEdge("boston", "newyork", 74);
        graph.addEdge("boston", "montreal", 69);

        graph.addEdge("lasvegas", "saltlakecity", 89);
        graph.addEdge("lasvegas", "losangeles", 66);

        graph.addEdge("chicago", "pittsburgh", 81);
        graph.addEdge("chicago", "saintlouis", 104);
        graph.addEdge("chicago", "omaha", 142);
        graph.addEdge("chicago", "duluth", 157);

        graph.addEdge("saultstemarie", "toronto", 90);
        graph.addEdge("saultstemarie", "montreal", 193);
        graph.addEdge("saultstemarie", "duluth", 110);
        graph.addEdge("saultstemarie", "winnipeg", 156);

        graph.addEdge("toronto", "montreal", 115);
        graph.addEdge("toronto", "saultstemarie", 90);
        graph.addEdge("toronto", "pittsburgh", 80);

        graph.addEdge("duluth", "winnipeg", 103);
        graph.addEdge("duluth","helena", 150);
        graph.addEdge("duluth","omaha",74);
        graph.addEdge("duluth","saultstemarie",110);
        graph.addEdge("duluth","chicago",157);

        graph.addEdge("omaha","duluth",74);
        graph.addEdge("omaha","helena",174);
        graph.addEdge("omaha","denver",130);
        graph.addEdge("omaha","chicago",142);

        graph.addEdge("kansascity","denver",135);
        graph.addEdge("kansascity","oklahomacity",61);
        graph.addEdge("kansascity","saintlouis",68);

        graph.addEdge("oklahomacity","santafe",121);
        graph.addEdge("oklahomacity","kansascity",61);
        graph.addEdge("oklahomacity","littlerock",72);

        graph.addEdge("phoenix", "losangeles", 109);
        graph.addEdge("phoenix", "santafe", 85);
        graph.addEdge("phoenix", "denver", 128);

        graph.addEdge("elpaso", "losangeles", 191);
        graph.addEdge("elpaso", "santafe", 65);
        graph.addEdge("elpaso", "dallas", 140);

        graph.addEdge("santafe","phoenix", 85);
        graph.addEdge("santafe","elpaso", 65);
        graph.addEdge("santafe","oklahomacity", 121);
        graph.addEdge("santafe","denver", 70);

        graph.addEdge("denver","saltlakecity", 101);
        graph.addEdge("denver","phoenix",128);
        graph.addEdge("denver","santafe",70);
        graph.addEdge("denver","helena",126);
        graph.addEdge("denver","omaha",130);
        graph.addEdge("denver","kansascity",135);

        graph.addEdge("dallas", "elpaso", 140);
        graph.addEdge("dallas", "houston", 46);
        graph.addEdge("dallas", "littlerock", 74);

        graph.addEdge("houston", "dallas", 46);
        graph.addEdge("houston", "neworleans", 80);

        graph.addEdge("neworleans", "houston", 80);
        graph.addEdge("neworleans", "littlerock", 100);
        graph.addEdge("neworleans", "atlanta", 120);
        graph.addEdge("neworleans", "miami", 151);

        graph.addEdge("littlerock", "oklahomacity", 72);
        graph.addEdge("littlerock", "saintlouis", 60);
        graph.addEdge("littlerock", "nashville", 94);
        graph.addEdge("littlerock", "neworleans", 100);
        graph.addEdge("littlerock", "dallas", 74);

        graph.addEdge("winnipeg", "calgary", 180);
        graph.addEdge("winnipeg", "helena", 137);
        graph.addEdge("winnipeg", "duluth", 103);
        graph.addEdge("winnipeg", "saultstemarie", 156);

        graph.addEdge("helena", "calgary", 130);
        graph.addEdge("helena", "seattle", 189);
        graph.addEdge("helena", "saltlakecity", 116);
        graph.addEdge("helena", "denver", 126);
        graph.addEdge("helena", "omaha", 174);
        graph.addEdge("helena", "duluth", 150);
        graph.addEdge("helena", "winnipeg", 137);

        graph.addEdge("saltlakecity", "helena", 116);
        graph.addEdge("saltlakecity", "portland", 175);
        graph.addEdge("saltlakecity", "sanfrancisco", 156);
        graph.addEdge("saltlakecity", "lasvegas", 89);
        graph.addEdge("saltlakecity", "denver", 101);

        graph.addEdge("washington", "newyork", 76);
        graph.addEdge("washington", "pittsburgh", 85);
        graph.addEdge("washington", "raleigh", 47);

        graph.addEdge("raleigh", "washington", 47);
        graph.addEdge("raleigh", "nashville", 128);
        graph.addEdge("raleigh", "atlanta", 96);
        graph.addEdge("raleigh", "charleston", 95);

        graph.addEdge("charleston", "raleigh", 95);
        graph.addEdge("charleston", "atlanta", 63);
        graph.addEdge("charleston", "miami", 80);

        graph.addEdge("atlanta", "raleigh", 96);
        graph.addEdge("atlanta", "charleston", 63);
        graph.addEdge("atlanta", "miami", 116);
        graph.addEdge("atlanta", "neworleans", 120);
        graph.addEdge("atlanta", "nashville", 67);

        graph.addEdge("nashville", "saintlouis", 85);
        graph.addEdge("nashville", "littlerock", 94);
        graph.addEdge("nashville", "atlanta", 67);
        graph.addEdge("nashville", "raleigh", 128);

        graph.addEdge("saintlouis", "chicago", 104);
        graph.addEdge("saintlouis", "kansascity", 68);
        graph.addEdge("saintlouis", "littlerock", 60);
        graph.addEdge("saintlouis", "nashville", 85);

        Pair<List<String>, List<String>> result = Algorithms.ucs(graph, "losangeles", "miami");
        List<String> path = result.getFirst();
        List<String> orderVisited = result.getSecond();

        System.out.println("Path found: " + path);
        System.out.println("Order of cities visited: " + orderVisited);
    }
}
