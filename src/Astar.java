import java.time.LocalTime;
import java.util.*;

public class Astar {

    public static void astarTimeCriteria(Graph graph, String start, String end, LocalTime startTime) {
        BusStop startNode = graph.getNodes().get(start);
        BusStop endNode = graph.getNodes().get(end);

        HashMap<BusStop, Connection> cameFrom = new HashMap<>();
        HashMap<BusStop, Integer> costSoFar = new HashMap<>();

        cameFrom.put(startNode, null);
        costSoFar.put(startNode, 0);
        Queue frontier = new PriorityQueue(Comparator.comparingInt(costSoFar::get));
        frontier.add(startNode);
        BusStop lastNode = null;
        int howManyConnections = 0;
        var currentTime = startTime;
        Map<BusStop, LocalTime> times;
        times = graph.getNodes().values().stream().collect(HashMap::new, (m, v) -> m.put(v, null), HashMap::putAll);
        times.put(startNode, startTime);
        Map<BusStop, BusStop> prevStops = new HashMap<>();
        prevStops.put(startNode, null);

        while (!frontier.isEmpty()) {
            BusStop currentNode = (BusStop) frontier.poll();
            lastNode = currentNode;
            if (currentNode.name.equals(end)) {break;}
            Connection connection = null;
            for (String neighbour : graph.getDirectConnections().get(currentNode.name)) {
                howManyConnections++;
                BusStop neighbourNode = graph.getNodes().get(neighbour);
                connection = graph.getEarliestConnection(currentNode.name, neighbour, currentTime);
                if (connection == null) {continue;}
                var newCost = costSoFar.get(currentNode) + graph.calculateCost(connection, currentTime);
                if (!costSoFar.containsKey(neighbourNode) || newCost < costSoFar.get(neighbourNode)) {
                    var priority = newCost + graph.euclideanDistance(endNode, neighbourNode);
                    costSoFar.put(neighbourNode, priority);
                    frontier.add(neighbourNode);
                    cameFrom.put(neighbourNode, connection);
                    prevStops.put(neighbourNode, currentNode);
                    times.put(neighbourNode, connection.arrivalTime);
                }
            }
            currentTime = prevStops.get(frontier.peek()) == null ? startTime : times.get(frontier.peek());
        }

        while(cameFrom.get(lastNode) != null) {
            System.out.println(cameFrom.get(lastNode));
            lastNode = prevStops.get(lastNode);
        }
        System.out.println("Number of visited neighbours: " + howManyConnections);
    }
}
