//319021457
package game;

import geometry.Point;

/**
 * A velocity class - to create a velocity from dx and dy.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor.
     * @param dx is the dx of the velocity.
     * @param dy is the dy of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Adds the dx and the dy of the velocity to x and y values of the given point.
     *
     * @param p the point to add to.
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        double x = this.dx + p.getX(), y = this.dy + p.getY();
        return new Point(x, y);
    }

    /**
     * @return the dx of the velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the dy of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Sets the dx of the velocity to a new value.
     *
     * @param dx1 the new value of dx.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * Sets the dy of the velocity to a new value.
     *
     * @param dy1 the new value of dy.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }

    /**
     * Converts angle and speed to dx and dy for the velocity.
     *
     * @param angle the angle of the velocity.
     * @param speed the speed of the velocity.
     * @return new velocity with the correct dx and dy.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = (float) (speed * Math.sin(Math.toRadians(angle)));
        double dy = (float) ((speed * -1) * Math.cos(Math.toRadians(angle)));
        return new Velocity(dx, dy);
    }
}
