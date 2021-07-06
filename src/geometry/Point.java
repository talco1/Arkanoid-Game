//319021457
package geometry;
/**
 * A point class - to create a point, compare between points and etc.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x is the x value of the point.
     * @param y is the y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the distance between this point and another point.
     *
     * @param other the point to compare to.
     * @return double number which represents the distance between the points.
     */
    public double distance(Point other) {
        //saves the x, y values of both points
        double x1 = this.getX(), y1 = this.getY(), x2 = other.getX(), y2 = other.getY();
        double sum = ((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2));
        return Math.sqrt(sum);
    }

    /**
     * Checks if the point is equal to another point.
     *
     * @param other the point to compare to.
     * @return true - if the points are equal, false - otherwise.
     */
    public boolean equals(Point other) {
        double epsilon = Math.pow(10, -14);
        if (Math.abs(this.getX() - other.getX()) <= epsilon && Math.abs(this.getY() - other.getY()) <= epsilon) {
       // if (this.getX() == other.getX() && this.getY() == other.getY()) {
            return true;
        }
        return false;
    }

    /**
     * @return the x value of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y value of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets the x value of the point to a new value.
     *
     * @param x1 the new value of x.
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * Sets the y value of the point to a new value.
     *
     * @param y1 the new value of y.
     */
    public void setY(double y1) {
        this.y = y1;
    }
}
