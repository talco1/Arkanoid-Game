//319021457
package listeners;

import game.Counter;
import game.GameLevel;
import hits.HitListener;
import objects.Ball;
import objects.Block;

/**
 * A BallRemover class - to remove a ball from the game.
 */
public class BallRemover implements HitListener {
    //fields
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Constructor.
     * @param gameLevel the ball game.
     * @param remainingBalls the number of balls remain in the game.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
