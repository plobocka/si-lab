import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
        var graph = DataLoader.getGraph();
        //graph.printGraph();
        var result = Dijkstra.shortestPath(graph, "Wielka", "PL. GRUNWALDZKI", LocalTime.of(10, 45, 0));
//        System.out.println(result[1]);

        Astar.astarTimeCriteria(graph, "Wielka", "PL. GRUNWALDZKI", LocalTime.of(10, 45, 0));
    }
}