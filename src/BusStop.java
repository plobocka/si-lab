import java.util.Objects;

public class BusStop {
    public String name;
    public double stopLat;
    public double stopLon;

    public BusStop(String name, double stopLat, double stopLon) {
        this.name = name;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStopLat() {
        return stopLat;
    }

    public void setStopLat(double stopLat) {
        this.stopLat = stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }

    public void setStopLon(double stopLon) {
        this.stopLon = stopLon;
    }

    @Override
    public String toString() {
        return "\t" + name +
                " " + stopLat +
                " " + stopLon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return Double.compare(busStop.stopLat, stopLat) == 0 && Double.compare(busStop.stopLon, stopLon) == 0 && Objects.equals(name, busStop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stopLat, stopLon);
    }
}
