import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
        var graph = DataLoader.getGraph();
        //graph.printGraph();
        var result = Dijkstra.shortestPath(graph, "Wielka", "PL. GRUNWALDZKI", LocalTime.of(12, 30, 0));
        //System.out.println(result[1]);
    }
}