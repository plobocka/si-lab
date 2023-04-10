import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Graph {

    private final Map<String, BusStop> nodes;
    private final Map<String, Set<Connection>> edges;
    private final Map<String, Set<String>> directConnections;

    public Graph(Map<String, BusStop> nodes, Map<String, Set<Connection>> edges, Map<String, Set<String>> directConnections) {
        this.nodes = nodes;
        this.edges = edges;
        this.directConnections = directConnections;
    }

    public void addEdge(Connection connection) {
        if (nodes.containsKey(connection.startStop.name) && nodes.containsKey(connection.endStop.name)) {
            String concatenatedName = connection.startStop.name + ";" + connection.endStop.name;
            edges.compute(concatenatedName, (key, values) -> {
                if (values == null) {
                    values = new HashSet<>();
                }
                values.add(connection);
                return values;
            });
            directConnections.compute(connection.startStop.name, (key, values) -> {
                if (values == null) {
                    values = new HashSet<>();
                }
                values.add(connection.endStop.name);
                return values;
            });
        }
    }

    public void addNode(BusStop start, BusStop end) {
        nodes.putIfAbsent(start.name, start);
        nodes.putIfAbsent(end.name, end);
    }

    public Map<String, BusStop> getNodes() {
        return nodes;
    }

    public Map<String, Set<Connection>> getEdges() {
        return edges;
    }

    public Map<String, Set<String>> getDirectConnections() {
        return directConnections;
    }

    public void printGraph() {
        System.out.println("Nodes:");
        nodes.forEach((key, value) -> System.out.println(key + " " + value));
//        System.out.println("Edges:");
//        edges.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public Integer calculateCost(Connection connection, LocalTime currentTime) {
        var result = Duration.between(currentTime, connection.departureTime).toMinutes();
        LocalTime end_day_time = LocalTime.of(23, 59, 59);
        return (int) (
                (result > 0
                        ? result
                        : result *-1 + Duration.between(currentTime, end_day_time).toMinutes())
                );
    }

    public Connection getEarliestConnection(String start, String end, LocalTime time) {
        Connection earliestConnection = null;
        long minDuration = Long.MAX_VALUE;
        for (Connection connection : getEdgesByNames(start, end)) {
            LocalTime departureTime = connection.departureTime;
            long duration = departureTime.isAfter(time)
                    ? Duration.between(time, departureTime).toMinutes()
                    : Long.MAX_VALUE;
            if (duration < minDuration) {
                minDuration = duration;
                earliestConnection = connection;
            }
        }
        return earliestConnection;
    }

    private Set<Connection> getEdgesByNames(String start, String end) {
        return edges.get(start + ";" + end);
    }
}
