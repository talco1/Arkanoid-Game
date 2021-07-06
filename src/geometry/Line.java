//319021457
package geometry;

import java.util.List;

/**
 * A line class - to create a line, compare between line and etc.
 */

public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor.
     * @param start is the start point of the line.
     * @param end is the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor.
     *
     * @param x1 is the x value of the start point of the line.
     * @param y1 is the y value of the start point of the line.
     * @param x2 is the x value of the end point of the line.
     * @param y2 is the y value of the end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Returns the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Checks what is the middle point of the line and returns it.
     *
     * @return the middle point of the line.
     */

    public Point middle() {
        double xm = (start.getX() + end.getX()) / 2;
        double ym = (start.getY() + end.getY()) / 2;
        return new Point(xm, ym);
    }

    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Checks what is the slope of the line and returns it.
     *
     * @return the slope of the line.
     */
    private double getSlope() {
        //slope of the straight line equation
        return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
    }

    /**
     *the method checks if the y-value of the point is between the y-values of both lines.
     *
     * @param other the line to compare to.
     * @param point the point to compare to.
     * @return true - if the y of the point is in the range of the y points of the lines. false - otherwise.
     */
    public boolean isOnY(Line other, Point point) {
        double yMinThisLine = Math.min(this.end.getY(), this.start.getY());
        double yMinOtherLine =  Math.min(other.end.getY(), other.start.getY());
        double yMaxThisLine = Math.max(this.end.getY(), this.start.getY());
        double yMaxOtherLine =  Math.max(other.end.getY(), other.start.getY());
        return point.getY() <= yMaxOtherLine && point.getY() >= yMinOtherLine
                && point.getY() <= yMaxThisLine && point.getY() >= yMinThisLine;
    }

    /**
     * This method is called if one line is vertical to the X axis.
     * Checks if the x value of the vertical line is between the start point and the end point of the other line.
     * if it is - than the lines intersect (the other line crosses this line).
     *
     * @param other the line to compare to.
     * @return true - if this line is crossing the other line, false - otherwise.
     */
    private boolean isIntersectingWithX(Line other) {
        double min = Math.min(other.start.getX(), other.end.getX());
        double max = Math.max(other.start.getX(), other.end.getX());
        return this.start.getX() >= min  && this.start.getX() <= max;
    }

    /**
     * This method is called if one line is parallel to the X axis.
     * Checks if the y value of the parallel line is between the start point and the end point of the other line.
     * if it is - than the lines intersect (the other line crosses this line).
     *
     * @param other the line to compare to.
     * @return true - if this line is crossing the other line, false - otherwise.
     */
    private boolean isIntersectingWithY(Line other) {
        double min = Math.min(this.start.getY(), this.end.getY());
        double max = Math.max(this.start.getY(), this.end.getY());
        return other.start.getY() >= min && other.start.getY() <= max;
    }
    /**
     * This method checks if the y points of the other line is between the y points of this line.
     *
     * @param other the line to compare to.
     * @return true - if the y points of the lines are between each other, false - otherwise.
     */
    private boolean isYInRange(Line other) {
        double minY = Math.min(other.start.getY(), other.end.getY());
        double maxY = Math.max(other.start.getY(), other.end.getY());
        if ((this.start.getY() <= minY && this.end.getY() <= minY)
                || this.start.getY() >= maxY && this.end.getY() >= maxY) {
            return false;
        }
        return true;
    }

    /**
     * This method checks if the x points of the other line is between the x points of this line.
     *
     * @param other the line to compare to.
     * @return true - if the x points of the lines are between each other, false - otherwise.
     */
    private boolean isXInRange(Line other) {
        double minX = Math.min(other.start.getX(), other.end.getX());
        double maxX = Math.max(other.start.getX(), other.end.getX());
        if ((this.start.getX() <= minX && this.end.getX() <= minX)
                || this.start.getX() >= maxX && this.end.getX() >= maxX) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the line is vertical to the X axis.
     *
     * @return true - if the line is vertical to the X axis, false - otherwise.
     */
    private boolean isVerticalToX() {
        return this.start.getX() == this.end.getX();
    }

    /**
     * Checks if the line is parallel to the X axis.
     *
     * @return true - if the line is parallel to the X axis, false - otherwise.
     */
    private boolean isParallelToX() {
        return this.start.getY() == this.end.getY();
    }

    /**
     * This method is called if one of the lines is a point.
     * Checks if the point intersect with the other line, and returns the intersection point.
     *
     * @param other the line to compare to.
     * @return if there is an intersection point - returns it, else - returns null.
     */
    public Point isIntersectingWithPoint(Line other) {
        if (this.start.equals(other.end) || this.start.equals(other.start)) {
            return this.start();
        }
        if ((other.isParallelToX() && this.isIntersectingWithY(other))
                || (other.isVerticalToX() && this.isIntersectingWithX(other))) {
            return this.start();
        }
        if (other.isXInRange(this) && other.isYInRange(this)) {
            return this.start();
        }
        return null;
    }

    /**
     * Checks if the intersection point of the lines is in the range of the segments.
     *
     * @param other the line to compare to.
     * @param point is the point to compare to.
     * @return true - if the intersection point is in the range, false - otherwise.
     */
    private boolean inRange(Line other, Point point) {
        double xMinThisLine = Math.min(this.end.getX(), this.start.getX());
        double xMinOtherLine =  Math.min(other.end.getX(), other.start.getX());
        double xMaxThisLine = Math.max(this.end.getX(), this.start.getX());
        double xMaxOtherLine =  Math.max(other.end.getX(), other.start.getX());
        if (xMaxThisLine < xMinOtherLine) {
            return false; //the lines don't intersect
        }
        if (point.getX() < Math.max(xMinOtherLine, xMinThisLine)
                || point.getX() > Math.min(xMaxOtherLine, xMaxThisLine)) {
            return false; //the intersection point is not in the range
        }
        return true; //the intersection point is in the range
    }

    /**
     * Checks what is the intersection point of the lines and returns it.
     *
     * @param other the line to compare to.
     * @return the point of intersection.
     */
    public Point intersectionWith(Line other) {
        //both lines are points
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            if (this.start.equals(other.start)) {
                return this.start(); //same point
            }
            return null; //different points
        }
        //one of the lines is a point
        if (this.start.equals(this.end)) {
            return this.isIntersectingWithPoint(other);
        }
        if (other.start.equals(other.end)) {
            return other.isIntersectingWithPoint(this);
        }
        //same lines
        if (this.equals(other)) {
            return null;
        }
        //both lines are vertical to x axis
        if (this.isVerticalToX() && other.isVerticalToX()) {
            if (this.start.getX() != other.start.getX()) {
                return null; //the lines have different x point
            }
            if (this.isYInRange(other) || other.isYInRange(this)) {
                return null; //if the lines have more than one intersection point
            }
            //y is in different range
            if (!(this.isYInRange(other))) {
                return null;
            }
            if (!(other.isYInRange(this))) {
                return null;
            }
            //the lines have exactly one intersection point, in the edges
            if (this.start.equals(other.start()) || this.start.equals(other.end())) {
                return this.start();
            }
            return this.end();
        }
        //one of the lines is vertical to x axis
        if (this.isVerticalToX()) {
            //the other is parallel to x axis, and the lines don't intersect
            if (other.isParallelToX() && !(this.isIntersectingWithY(other) && this.isIntersectingWithX(other))) {
                return null;
            }
            double m = other.getSlope(); //slope of the other line
            double b = other.start.getY() - (m * other.start.getX());
            //get the intersection point of the lines
            double y = (m * this.start.getX()) + b;
            Point intersectionPoint = new Point(this.start.getX(), y);
            //if the intersection point is in the y range of both lines
            if (this.isOnY(other, intersectionPoint)) {
                if (other.isParallelToX()) {
                    return new Point(this.start.getX(), other.start.getY());
                }
                return intersectionPoint;
            }
            return null; //there is no intersection point
        }
        if (other.isVerticalToX()) {
            //the other is parallel to x axis, and the lines don't intersect
            if (this.isParallelToX() && !(other.isIntersectingWithY(this)
                    && other.isIntersectingWithX(this))) {
                return null;
            }
            double m = this.getSlope(); //slope of the other line
            double b = this.start.getY() - (m * this.start.getX());
            //get the intersection point of the lines
            double y = (m * other.start.getX()) + b;
            Point intersectionPoint = new Point(other.start.getX(), y);
            //if the intersection point is in the y range of both lines
            if (other.isOnY(this, intersectionPoint)) {
                if (this.isParallelToX()) {
                    return new Point(other.start.getX(), this.start.getY());
                }
                return intersectionPoint;
            }
            return null; //there is no intersection point
        }
        //get the equation of both lines: y=mx+b
        double m1 = this.getSlope();
        double m2 = other.getSlope();
        double b1 = this.start.getY() - (m1 * this.start.getX());
        double b2 = other.start.getY() - (m2 * other.start.getX());
        //if the lines have the same slope
        if (m1 == m2) {
            if (b1 != b2) {
                return null; //different line
            }
            if ((this.isYInRange(other) || other.isYInRange(this))
                    && (this.isXInRange(other) || other.isXInRange(this))) {
                return null; //more than one intersection point
            }
            //exactly one intersection point
            if (this.start.equals(other.start()) || this.start.equals(other.end())) {
                return this.start();
            }
            if (this.end.equals(other.start()) || this.end.equals(other.end())) {
                return this.end();
            }
            return null; //this lines don't intersect in one point
        }
        //the x and y values of the intersection point
        double x = ((b2 - b1) / (m1 - m2));
        double y = ((m1 * x) + b1);
        Point intersectionPoint = new Point(x, y);
        //if the intersection point is in the range of both segments
        if (this.inRange(other, intersectionPoint)) {
            if (this.isParallelToX()) {
                return new Point(((this.start.getY() - b2) / m2), this.start.getY());
            }
            if (other.isParallelToX()) {
                return new Point(((other.start.getY() - b1) / m1), other.start.getY());
            }
            return intersectionPoint;
        }
        return null; //there is no intersection point between the segments
    }

    /**
     * Checks if the lines intersect.
     *
     * @param other the line to compare to.
     * @return true - if the lines intersect, false - otherwise.
     */
    public boolean isIntersecting(Line other) {
        return this.intersectionWith(other) != null;
    }

    /**
     * Checks if the lines are equal.
     *
     * @param other the line to compare to.
     * @return true - if the lines are equal, false - otherwise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start()) && this.end.equals(other.end()))
                || (this.start.equals(other.end()) && this.end.equals(other.start()));
    }

    /**
     * The method checks if the line intersect with the rectangle, and returns the closest intersection point.
     *
     * @param rect the rectangle to check with.
     * @return the closest intersection point to the start of the line, or null if there isn't intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //get all the intersection points between the line and the rectangle
        List<Point> points = rect.intersectionPoints(new Line(this.start, this.end));
        //List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            return null; //the line does not intersect with the rectangle
        }
        if (points.size() == 1) {
            return points.get(0); //there is one intersection point
        }
        //the maximum number of intersection points is 2
        //else - there are exactly two intersection points
        //get the distance of the intersection points to the start of the line
        double dist1 = this.start.distance(points.get(0)), dist2 = this.start.distance(points.get(1));
        //returns the closest intersection point
        if (dist1 < dist2) {
            return points.get(0);
        }
        return points.get(1);
    }
}
