import java.time.LocalTime;
import java.util.Objects;

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
        return "\tLine: " + line + '\'' +
                "\tdepartureTime: " + departureTime +
                "\tarrivalTime: " + arrivalTime +
                "\tstartStop: " + startStop +
                "\tendStop: " + endStop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(line, that.line) && Objects.equals(departureTime, that.departureTime) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(startStop, that.startStop) && Objects.equals(endStop, that.endStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, departureTime, arrivalTime, startStop, endStop);
    }
}
