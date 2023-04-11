import java.time.LocalTime;
import java.util.*;

public class Dijkstra {
    public static Object[] shortestPath(Graph graph, String start, String end, LocalTime startTime) {
        BusStop startNode = graph.getNodes().get(start);
        Map<BusStop, LocalTime> times;
        times = graph.getNodes().values().stream().collect(HashMap::new, (m, v) -> m.put(v, null), HashMap::putAll);
        Map<BusStop, Double> distances = new HashMap<>();
        for (BusStop busStop : graph.getNodes().values()) {
            distances.put(busStop, Double.POSITIVE_INFINITY);
        }
        distances.put(startNode, 0.0);
        Queue queue = new PriorityQueue<>(
                Comparator.comparingDouble(distances::get)
        );
        Map<BusStop, BusStop> prevStops = new HashMap<>();
        Map<BusStop, Connection> prevConnection = new HashMap<>();

        queue.add(startNode);
        prevStops.put(startNode, null);
        times.put(startNode, startTime);
        LocalTime currentTime = startTime;
        BusStop lastNode = null;
        int howManyConnections = 0;

        while (!queue.isEmpty()) {
            BusStop currentNode = (BusStop) queue.poll();
            double currentDistance = distances.get(currentNode);
            lastNode = currentNode;
            if (currentNode.name.equals(end)) {break;}
            Connection connection = null;
            for (String neighbour : graph.getDirectConnections().get(currentNode.name)) {

                BusStop neighbourNode = graph.getNodes().get(neighbour);
                connection = graph.getEarliestConnection(currentNode.name, neighbour, currentTime);
                if (connection == null) {continue;}
                var newCost = currentDistance + graph.calculateCost(connection, currentTime);
                if (newCost < distances.get(neighbourNode)) {
                    distances.put(neighbourNode, newCost);
                    prevStops.put(neighbourNode, currentNode);
                    times.put(neighbourNode, connection.arrivalTime);
                    prevConnection.put(neighbourNode, connection);
                    queue.add(neighbourNode);
                    howManyConnections++;
                }
            }
            currentTime = prevStops.get(queue.peek()) == null ? startTime : times.get(queue.peek());
        }
        while(prevConnection.get(lastNode) != null) {
            System.out.println(prevConnection.get(lastNode));
            lastNode = prevStops.get(lastNode);
        }
        System.out.println("Number of visited neighbours: " + howManyConnections);
        return new Object[]{distances, prevStops};
    }
}
