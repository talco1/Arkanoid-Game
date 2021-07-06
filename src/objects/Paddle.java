//319021457
package objects;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collide.Collidable;
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
 * A objects.Paddle class - to create a paddle, draw it and etd.
 */
public class Paddle implements Sprite, Collidable {
    //screen size
    static final int MOVE_ONE_STEP = 10;
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     * @param rect is the rectangle of the paddle.
     * @param color is the color of the paddle.
     * @param gameEnvironment is the game environment of the paddle.
     * @param keyboard is the keyboard of the paddle
     */
    public Paddle(Rectangle rect, java.awt.Color color, GameEnvironment gameEnvironment,
                  biuoop.KeyboardSensor keyboard) {
        this.color = color;
        this.rect = rect;
        this.gameEnvironment = gameEnvironment;
        this.keyboard = keyboard;
    }

    /**
     * Moves the paddle one step to the left.
     */
    public void moveLeft() {
        //adding the step to the upper left point of the rectangle of the paddle
        Point newPoint = new Point(this.rect.getUpperLeft().getX() - MOVE_ONE_STEP,
                this.rect.getUpperLeft().getY());
        //creating a new rectangle from the new upper left point
        Rectangle rec = new Rectangle(newPoint, this.rect.getWidth(), this.rect.getHeight());
        //searching if the new rectangle has a collision with another object of the game environment
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(rec.getTopLine());
        //the paddle collides with a block from the game environment
        if (collisionInfo != null) {
            Line topLine = collisionInfo.collisionObject().getCollisionRectangle().getTopLine();
            Line leftLine = collisionInfo.collisionObject().getCollisionRectangle().getLeftLine();
            if (!(!topLine.equals(this.rect.getTopLine()) && !leftLine.equals(this.rect.getLeftLine()))) {
                this.rect = rec; //change the rectangle of the paddle to the new one
            }
        } else {
            this.rect = rec; //there is no collide
        }
    }

    /**
     * Moves the paddle one step to the right.
     */
    public void moveRight() {
        //adding the step to the upper left point of the rectangle of the paddle
        Point newPoint = new Point(this.rect.getUpperLeft().getX() + MOVE_ONE_STEP,
                this.rect.getUpperLeft().getY());
        //creating a new rectangle from the new upper left point
        Rectangle rec = new Rectangle(newPoint, this.rect.getWidth(), this.rect.getHeight());
        Line trajectory = new Line(rec.getTopLine().end(), rec.getTopLine().start());
        //searching if the paddle has a collision with another object of the game environment
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        //the paddle collides with a block from the game environment
        if (collisionInfo != null) {
            Line topLine = collisionInfo.collisionObject().getCollisionRectangle().getTopLine();
            Line rightLine = collisionInfo.collisionObject().getCollisionRectangle().getRightLine();
            if (!(!topLine.equals(this.rect.getTopLine()) && !rightLine.equals(this.rect.getRightLine()))) {
                this.rect = rec; //change the rectangle of the paddle to the new one
            }
        } else {
            this.rect = rec; //there is no collide
        }
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double region = this.rect.getWidth() / 5;
        //converting dx and dy to speed
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        double x = this.rect.getUpperLeft().getX();
        //the hit is in the first region
        if (collisionPoint.getX() >= x && collisionPoint.getX() < (x + region)) {
            return Velocity.fromAngleAndSpeed(300, speed);
        }
        //the hit is in the second region
        if (collisionPoint.getX() >= (x + region) && collisionPoint.getX() < (x + (2 * region))) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }
        //the hit is in the third region
        if (collisionPoint.getX() >= (x + (2 * region)) && collisionPoint.getX() < (x + (3 * region))) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        //the hit is in the forth region
        if (collisionPoint.getX() >= (x + (3 * region)) && collisionPoint.getX() < (x + (4 * region))) {
            return Velocity.fromAngleAndSpeed(30, speed);
        }
        //the hit is in the fifth region
        if (collisionPoint.getX() >= (x + (4 * region)) && collisionPoint.getX() <= (x + (5 * region))) {
            return Velocity.fromAngleAndSpeed(60, speed);
        }
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //drawing the rectangle
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        //drawing the lines of the rectangle
        d.setColor(Color.BLACK); //sets black color for the line
        d.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {
        //move the paddle according to the keyboard press
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Adding the paddle to the game.
     *
     * @param g the game to add to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
