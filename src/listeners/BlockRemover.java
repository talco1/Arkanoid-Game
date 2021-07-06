//319021457
package listeners;

import game.Counter;
import game.GameLevel;
import hits.HitListener;
import objects.Ball;
import objects.Block;

/**
 * A BlockRemover class - to remove a block from the game.
 */
public class BlockRemover implements HitListener {
    //fields
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Constructor.
     * @param gameLevel the game.
     * @param remainingBlocks the number of blocks remain in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        this.remainingBlocks.decrease(1);
    }
}
