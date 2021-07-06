//319021457
package game;

import collide.Collidable;
import collide.CollisionInfo;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * A GameEnvironment class - to create the environment of the game.
 */
public class GameEnvironment {
    //fields
    private List<Collidable> collidables;

    /**
     * Constructor.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * The method adds a collidable to the array list.
     *
     * @param c the Collide.Collidable object to add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * The method removes a collidable from the array list.
     *
     * @param c the Collide.Collidable object to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * The method searches the closest collision point to the start of the line with a collidable from the list.
     * If there is no collision the method returns null.
     * Else, it returns the information about the closest collision.
     *
     * @param trajectory the line that represents a movement of an object.
     * @return the information about the closest collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //there are no collidables in the environment
        if (this.collidables == null) {
            return null;
        }
        //object is the object of the closest collision point
        //minPoint is the closest collision point
        Collidable object = null;
        Point minPoint = null;
        double minDist = -1, tempDist;
        //search in the collidable array list
        for (Collidable c : this.collidables) {
            Rectangle r = c.getCollisionRectangle();
            //tempPoint is the current intersection point of the line and a collidable
            Point tempPoint = trajectory.closestIntersectionToStartOfLine(r);
            if (tempPoint != null) {
                //the distance from the start of the line to the collision point
                tempDist = trajectory.start().distance(tempPoint);
                if (minDist == -1 || tempDist < minDist) {
                    minDist = tempDist; //current distance
                    minPoint = tempPoint; //current collision point
                    object = c; //current object
                }
            }
        }
        //there is no collision
        if (minDist == -1) {
            return null;
        }
        return new CollisionInfo(minPoint, object);
    }
}
