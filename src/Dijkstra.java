import java.time.LocalTime;
import java.util.*;

public class Dijkstra {
    public static Object[] shortestPath(Graph graph, String start, String end, LocalTime startTime) {
        BusStop startNode = graph.getNodes().get(start);
        Map<BusStop, LocalTime> times;
        times = graph.getNodes().values().stream().collect(HashMap::new, (m, v) -> m.put(v, null), HashMap::putAll);

        // koszt jako odleglosc w minutach
        Map<BusStop, Double> distances = new HashMap<>();
        for (BusStop busStop : graph.getNodes().values()) {
            distances.put(busStop, Double.POSITIVE_INFINITY);
        }
        distances.put(startNode, 0.0);
        times.put(startNode, startTime);

        //times.put(startNode, startTime);
        LocalTime currentTime = startTime;

        // Kolejka priororytetowa przechowująca przystanki do odwiedzenia
        Queue queue = new PriorityQueue<>(
                Comparator.comparingDouble(distances::get)
        );
        queue.add(startNode);

        // Mapa przechowująca poprzedników
        Map<BusStop, BusStop> prevStops = new HashMap<>();
        for (BusStop busStop : graph.getNodes().values()) {
            prevStops.put(busStop, null);
        }

        var lastNode = startNode;

        while (!queue.isEmpty()) {
            BusStop currentNode = (BusStop) queue.poll();
            double currentDistance = distances.get(currentNode);
            lastNode = currentNode;


            for (String neighbour : graph.getDirectConnections().get(currentNode.name)) {
                // sasiedni przystanek jako obiekt BusStop
                BusStop neighbourNode = graph.getNodes().get(neighbour);
                Connection connection = graph.getEarliestConnection(currentNode.name, neighbour, currentTime);
                if (connection == null) {
                    continue;
                }
                var newCost = currentDistance + graph.calculateCost(connection, currentTime);
                if (newCost < distances.get(neighbourNode)) {
                    distances.put(neighbourNode, newCost);
                    prevStops.put(neighbourNode, currentNode);
                    times.put(neighbourNode, connection.departureTime);
                    queue.add(neighbourNode);
                }
                currentTime = prevStops.get(neighbourNode) == null ? startTime : times.get(prevStops.get(neighbourNode));
            }

            if (currentNode.name.equals(end)) {
                break;
            }
        }

        while (prevStops.get(lastNode) != null) {
//            System.out.println(lastNode);
            System.out.print(times.get(lastNode) + " ");
            System.out.print(lastNode.name + " - ");

            System.out.print(distances.get(lastNode));
            lastNode = prevStops.get(lastNode);
            System.out.println();
        }

        return new Object[]{distances, prevStops};
    }
}
