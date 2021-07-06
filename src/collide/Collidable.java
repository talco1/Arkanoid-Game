//319021457
package collide;

import game.Velocity;
import geometry.Point;
import geometry.Rectangle;
import objects.Ball;

/**
 * Collidable interface - every collidable object implements this interface.
 */
public interface Collidable {

    /**
     * the method returns the rectangle that collided with another object.
     *
     * @return the collision rectangle.
     */
    Rectangle getCollisionRectangle();

    /**
     * the method returns the new velocity of the object that we collided with.
     *
     * @param hitter the hitter ball collided with us.
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity of the other object.
     * @return the new velocity of the object that we collided with.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}