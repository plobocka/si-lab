import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        var graph = DataLoader.getGraph();

//        test(graph);

        System.out.println("Dijkstra result:");
        var startOfTest = Instant.now();
        Dijkstra.shortestPath(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        var duration = Duration.between(startOfTest, Instant.now()).toMillis();
        System.out.println("Duration: " + duration + "ms");
        System.out.println("A* time criteria result:");
        startOfTest = Instant.now();
        Astar.astarTimeCriteria(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        duration = Duration.between(startOfTest, Instant.now()).toMillis();
        System.out.println("Duration: " + duration + "ms");
        System.out.println("A* changes criteria result:");
        startOfTest = Instant.now();
        Astar.astarChangesCriteria(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        duration = Duration.between(startOfTest, Instant.now()).toMillis();
        System.out.println("Duration: " + duration + "ms");
        System.out.println("A* time criteria optimized result:");
        startOfTest = Instant.now();
        Astar.astarChangesCriteriaOptimized(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        duration = Duration.between(startOfTest, Instant.now()).toMillis();
        System.out.println("Duration: " + duration + "ms");




/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start node: ");
        String start = scanner.nextLine();
        System.out.println("Enter end node: ");
        String end = scanner.nextLine();
        System.out.println("Enter start time hours: ");
        int hours = scanner.nextInt();
        System.out.println("Enter start time minutes: ");
        int minutes = scanner.nextInt();
        if (areDataValid(graph, start, end, hours, minutes))
            return;
        LocalTime startTime = LocalTime.of(hours, minutes);
        System.out.println("Enter criteria (d - dijkstra, t - a* time, p - a* changes: ");
        String criteria = scanner.next();
        startOfTest = Instant.now();
        switch (criteria) {
            case "d":
                Dijkstra.shortestPath(graph, start, end, startTime);
                break;
            case "t":
                Astar.astarTimeCriteria(graph, start, end, startTime);
                break;
            case "p":
                Astar.astarChangesCriteria(graph, start, end, startTime);
                break;
            default:
                System.out.println("Wrong criteria");
        }
        duration = Duration.between(startOfTest, Instant.now()).toMillis();
        System.out.println("Duration: " + duration + "ms");
 */
    }

    private static boolean areDataValid(Graph graph, String start, String end, int hours, int minutes) {
        boolean error = false;
        if (!graph.getNodes().containsKey(start)) {
            System.out.println("Start node does not exist");
            error = true;
        }
        if (!graph.getNodes().containsKey(end)) {
            System.out.println("End node does not exist");
            error = true;
        }
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            System.out.println("Invalid time");
            error = true;
        }
        return error;
    }

    private static void test(Graph graph) {
        System.out.println("Dijkstra result:");
        Dijkstra.shortestPath(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        System.out.println("A* time criteria result:");
        Astar.astarTimeCriteria(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        System.out.println("A* changes criteria result:");
        Astar.astarChangesCriteria(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));
        System.out.println("A* time criteria optimized result:");
        Astar.astarChangesCriteriaOptimized(graph, "Magellana", "Śrubowa", LocalTime.of(9, 17, 0));

        System.out.println("Dijkstra result:");
        Dijkstra.shortestPath(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
        System.out.println("A* result:");
        Astar.astarTimeCriteria(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
        System.out.println("A* changes criteria result:");
        Astar.astarChangesCriteria(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));
        System.out.println("A* time criteria optimized result:");
        Astar.astarChangesCriteriaOptimized(graph, "Wielka", "KLECINA", LocalTime.of(10, 45, 0));

        System.out.println("Dijkstra result:");
        Dijkstra.shortestPath(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
        System.out.println("A* time criteria result:");
        Astar.astarTimeCriteria(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
        System.out.println("A* changes criteria result:");
        Astar.astarChangesCriteria(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
        System.out.println("A* time criteria optimized result:");
        Astar.astarChangesCriteriaOptimized(graph, "Godebskiego (AWF Wrocław)", "PORT LOTNICZY", LocalTime.of(15, 00, 0));
    }
}