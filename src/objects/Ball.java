//319021457
package objects;
import biuoop.DrawSurface;
import collide.CollisionInfo;
import game.GameLevel;
import game.GameEnvironment;
import game.Velocity;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import sprite.Sprite;

import java.awt.Color;

/**
 * A ball class - to create a ball, draw it and etc.
 */
public class Ball implements Sprite {
    //fields
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     * @param center is the center point of the ball.
     * @param r is the radius of the ball.
     * @param color is the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0.0, 0.0);
    }

    /**
     * Constructor.
     * @param x is the x value of the center point of the ball.
     * @param y is the y value of the center point of the ball.
     * @param r is the radius of the ball.
     * @param color is the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0.0, 0.0);
    }

    /**
     * Constructor.
     * @param center is the center point of the ball.
     * @param r is the radius of the ball.
     * @param color is the color of the ball.
     * @param gameEnvironment is game environment for the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0.0, 0.0);
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * @return the game environment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * Sets the game environment of the ball to a new value.
     *
     * @param gameEnvironment1 the new game environment of the ball.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * @return the x value of the center point of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return the y value of the center point of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the size of the ball - its radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draws the ball on the given DrawSurface.
     *
     * @param surface the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        //drawing the ball
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), this.r);
        //drawing the scope of the ball
        surface.setColor(Color.BLACK);
        surface.drawOval((int) this.getX() - r, (int) this.getY() - r, this.r * 2, this.r * 2);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Sets the velocity of the ball to a new value.
     *
     * @param v1 the new value of the velocity.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * Sets the velocity of the ball to a new value.
     *
     * @param dx the new dx value of the velocity.
     * @param dy the new dy value of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Moves the ball one step according to its velocity (by adding the velocity to the center point).
     */
    public void moveOneStep() {
        //creating the trajectory of the move of the ball
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        //getting the closest collision with the ball
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo == null) {
            this.center = trajectory.end(); //the trajectory is fine
        } else {
            Rectangle rect = collisionInfo.collisionObject().getCollisionRectangle();
            Point intersectionPoint = collisionInfo.collisionPoint();
            //the line is the intersection point
            Line intersectionPointToLine = new Line(intersectionPoint, intersectionPoint);
            //updating the location of the ball
            if (intersectionPointToLine.isIntersecting(rect.getTopLine())) {
                this.center.setY(intersectionPoint.getY() - this.r); //the ball hits the top line of the rectangle
            }
            if (intersectionPointToLine.isIntersecting(rect.getBottomLine())) {
                this.center.setY(intersectionPoint.getY() + this.r); //the ball hits the bottom line of the rectangle
            }
            if (intersectionPointToLine.isIntersecting(rect.getRightLine())) {
                this.center.setX(intersectionPoint.getX() + this.r); //the ball hits the right line of the rectangle
            }
            if (intersectionPointToLine.isIntersecting(rect.getLeftLine())) {
                this.center.setX(intersectionPoint.getX() - this.r); //the ball hits the left line of the rectangle
            }
            //updating the velocity of the ball
            this.setVelocity(collisionInfo.collisionObject().hit(this, intersectionPoint, this.getVelocity()));
        }
    }

    /**
     * Adding the ball to the game.
     *
     * @param g the game to add the ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Removing the ball from the game.
     *
     * @param g the game to remove the ball from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
