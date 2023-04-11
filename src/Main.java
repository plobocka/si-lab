import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
        var graph = DataLoader.getGraph();

//        System.out.println("Dijkstra result:");
//        var result1 = Dijkstra.shortestPath(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));
//        System.out.println("A* time criteria result:");
//        Astar.astarTimeCriteria(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));
//        System.out.println("A* changes criteria result:");
//        Astar.astarChangesCriteria(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));
//        System.out.println("A* time criteria optimized result:");
//        Astar.astarChangesCriteriaOptimized(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));

//        System.out.println("Dijkstra result:");
//        var result2 = Dijkstra.shortestPath(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
//        System.out.println("A* result:");
//        Astar.astarTimeCriteria(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
//        System.out.println("A* changes criteria result:");
//        Astar.astarChangesCriteria(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
//        System.out.println("A* time criteria optimized result:");
//        Astar.astarChangesCriteriaOptimized(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
//
        System.out.println("Dijkstra result:");
        var result3 = Dijkstra.shortestPath(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
        System.out.println("A* time criteria result:");
        Astar.astarTimeCriteria(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
        System.out.println("A* changes criteria result:");
        Astar.astarChangesCriteria(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
        System.out.println("A* time criteria optimized result:");
        Astar.astarChangesCriteriaOptimized(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
//

    }
}