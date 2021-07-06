//319021457
package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * A rectangle class - to create a rectangle.
 */
public class Rectangle {
    //fields
    private Point upperLeft;
    private double width;
    private double height;
    private Line topLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;

    /**
     * Constructor.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //updating the lines of the rectangle
        this.topLine = new Line(upperLeft, new Point(upperLeft.getX() + width, upperLeft.getY()));
        this.leftLine = new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + height));
        this.rightLine = new Line(this.topLine.end(), new Point(upperLeft.getX() + width,
                upperLeft.getY() + height));
        this.bottomLine = new Line(this.leftLine.end(), this.rightLine.end());
    }

    /**
     * The method returns a list of intersection points with the line.
     *
     * @param line the line to compare to.
     * @return a list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        //intersection point with the top line of the rectangle
        Point point = line.intersectionWith(this.topLine);
        if (point != null) {
            intersectionPoints.add(point);
        }
        //intersection point with the left line of the rectangle
        point = line.intersectionWith(this.leftLine);
        if (point != null) {
            //if the intersection point already exists in the array
            if (!(!intersectionPoints.isEmpty() && point.equals(intersectionPoints.get(0)))) {
                intersectionPoints.add(point);
            }
        }
        //intersection point with the right line of the rectangle
        point = line.intersectionWith(this.rightLine);
        if (point != null) {
            //if the intersection point already exists in the array
            if (!(!intersectionPoints.isEmpty() && point.equals(intersectionPoints.get(0)))) {
                intersectionPoints.add(point);
            }
        }
        //intersection point with the bottom line of the rectangle
        point = line.intersectionWith(this.bottomLine);
        if (point != null) {
            //if the intersection point already exists in the array
            if (!(!intersectionPoints.isEmpty() && point.equals(intersectionPoints.get(0)))) {
                intersectionPoints.add(point);
            }
        }
        return intersectionPoints;
    }

    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * @return the top line of the rectangle.
     */
    public Line getTopLine() {
        return topLine;
    }

    /**
     * @return the bottom line of the rectangle.
     */
    public Line getBottomLine() {
        return bottomLine;
    }

    /**
     * @return the the left line of the rectangle.
     */
    public Line getLeftLine() {
        return leftLine;
    }

    /**
     * @return the left line of the rectangle.
     */
    public Line getRightLine() {
        return rightLine;
    }
}
