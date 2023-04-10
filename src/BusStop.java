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
        return "BusStop{" +
                "name='" + name + '\'' +
                ", stopLat=" + stopLat +
                ", stopLon=" + stopLon +
                '}';
    }
}
