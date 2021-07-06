//319021457
package hits;

import objects.Ball;
import objects.Block;

/**
 * A hitListener interface - every listener object implement this interface.
 */
public interface HitListener {

    /**
     * The method is called whenever the beingHit object is hit.
     * The method is in charge of the event occurs after an object is hit.
     *
     * @param beingHit the object that got hit.
     * @param hitter the hitter ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
