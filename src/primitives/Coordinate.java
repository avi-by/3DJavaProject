package primitives;

public class Coordinate implements Comparable<Coordinate> {
    public static Coordinate ZERO = new Coordinate(0.0);
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
        return "" + coordinate;
    }

    @Override
    public int compareTo(Coordinate o) {
        if (coordinate == o.coordinate)
            return 0;
        else
            return -1;
    }

    public Coordinate subtract(Coordinate other) {
        return new Coordinate(Util.usubtract(coordinate, other.coordinate));
    }

    public Coordinate add(Coordinate other) {
        return new Coordinate(Util.uadd(coordinate, other.coordinate));
    }

    /**
     *
     * @param num
     * @return new updated Coordinate
     */
    public Coordinate scale(double num) {

        return new Coordinate(Util.uscale(coordinate, num));
    }

    public Coordinate multiply(Coordinate other) {
        return new Coordinate(Util.uscale(coordinate, other.coordinate));
    }
}

