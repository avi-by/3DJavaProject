package primitives;

public class Coordinate implements Comparable<Coordinate> {
    double coordinate;

    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate() {
        this.coordinate = 0;
    }

    public Coordinate(Coordinate c) {
        this.coordinate = c.coordinate;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "coordinate= " + coordinate;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (coordinate == o.coordinate)
            return 1;
        else
            return 0;
    }

    public void add (Coordinate c){
        coordinate += c.coordinate;
    }

    public void Substrct  (Coordinate c){
        coordinate -= c.coordinate;
    }
}
