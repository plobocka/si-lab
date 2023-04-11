import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
        var graph = DataLoader.getGraph();
        //graph.printGraph();
        System.out.println("Dijkstra result:");
        var result1 = Dijkstra.shortestPath(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));
        System.out.println("A* time criteria result:");
        Astar.astarTimeCriteria(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));
        System.out.println("A* changes criteria result:");
        Astar.astarChangesCriteria(graph, "Magellana", "Rogowska", LocalTime.of(9, 17, 0));

//        System.out.println("Dijkstra result:");
//        var result2 = Dijkstra.shortestPath(graph, "Wielka", "Klimasa", LocalTime.of(10, 45, 0));
//        System.out.println("A* result:");
//        Astar.astarTimeCriteria(graph, "Wielka", "Klimasa", LocalTime.of(10, 45, 0));
//        System.out.println("A* changes criteria result:");
//        Astar.astarChangesCriteria(graph, "Wielka", "Klimasa", LocalTime.of(10, 45, 0));


//        System.out.println("Dijkstra result:");
//        var result3 = Dijkstra.shortestPath(graph, "BISKUPIN", "Renoma", LocalTime.of(15, 00, 0));
//        System.out.println("A* time criteria result:");
//        Astar.astarTimeCriteria(graph, "BISKUPIN", "Renoma", LocalTime.of(15, 00, 0));
//        System.out.println("A* changes criteria result:");
//        Astar.astarChangesCriteria(graph, "BISKUPIN", "Renoma", LocalTime.of(15, 00, 0));


    }
}