//319021457
package collide;
import geometry.Point;

/**
 * A CollisionInfo class - to save a collision point and the collision object.
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor.
     * @param collisionPoint is the collision point of the objects.
     * @param collisionObject is the collision object we collided with.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
