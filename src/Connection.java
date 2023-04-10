import java.time.LocalTime;

public class Connection {
    public String line;
    public LocalTime departureTime;
    public LocalTime arrivalTime;
    public BusStop startStop;
    public BusStop endStop;

    public Connection(String line, LocalTime departureTime, LocalTime arrivalTime, BusStop startStop, BusStop endStop) {
        this.line = line;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.startStop = startStop;
        this.endStop = endStop;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BusStop getStartStop() {
        return startStop;
    }

    public void setStartStop(BusStop startStop) {
        this.startStop = startStop;
    }

    public BusStop getEndStop() {
        return endStop;
    }

    public void setEndStop(BusStop endStop) {
        this.endStop = endStop;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "line='" + line + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", startStop=" + startStop +
                ", endStop=" + endStop +
                '}';
    }
}
