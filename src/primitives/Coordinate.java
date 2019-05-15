package primitives;

public class Coordinate implements Comparable<Coordinate> {
    private double coordinate;

    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate() {
        this.coordinate = 0;
    }

    public Coordinate(Coordinate c) {
        this.coordinate = c.getCoordinate();
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return ""+coordinate;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (coordinate == o.coordinate)
            return 0;
        else
            return -1;
    }

    public void add (Coordinate c){
        coordinate += c.coordinate;
    }

    public void subtract(Coordinate c){
        coordinate -= c.coordinate;
    }
}

