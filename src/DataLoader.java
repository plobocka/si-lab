import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.HashMap;

public class DataLoader {
    private static Graph graph = null;

    public static Graph getGraph() throws Exception {
        if (graph == null) {
            load();
        }
        return graph;
    }

    private static Graph load() throws Exception {
        System.out.println("Loading data...");
        Path filePath = Path.of("src/connection_graph.csv");
        graph = new Graph(new HashMap<>(), new HashMap<>(), new HashMap<>());
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                BusStop start = new BusStop(row[5], Double.parseDouble(row[7]), Double.parseDouble(row[8]));
                BusStop end = new BusStop(row[6], Double.parseDouble(row[9]), Double.parseDouble(row[10]));
                Connection connection = new Connection(row[2], getTime(row[3]), getTime(row[4]), start, end);
                graph.addNode(start, end);
                graph.addEdge(connection);
            }
        }
        return graph;
    }

    private static LocalTime getTime(String time) {
        var splitHour = time.split(":");
        var hour = Integer.parseInt(splitHour[0]);

        if (hour < 24) {
            return LocalTime.parse(time);
        } else {
            splitHour[0] = "0" + (hour % 24);
            return LocalTime.parse(String.join(":", splitHour));
        }
    }
}
