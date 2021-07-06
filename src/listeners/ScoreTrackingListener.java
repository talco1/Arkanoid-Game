//319021457
package listeners;

import game.Counter;
import hits.HitListener;
import objects.Ball;
import objects.Block;

/**
 * A ScoreTrackingListener class - to track thr score of the game.
 */
public class ScoreTrackingListener implements HitListener {
    //field
    private Counter currentScore;

    /**
     * Constructor.
     * @param scoreCounter the first score of the player.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}
