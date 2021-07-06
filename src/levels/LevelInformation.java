//319021457
package levels;
import game.Velocity;
import objects.Block;
import sprite.Sprite;
import java.util.List;

/**
 * Level Information - to hold and return the information about the level.
 */
public interface LevelInformation {
    /**
     * @return the number of the balls in thr game.
     */
    int numberOfBalls();

    /**
     * The method initializes the initial velocity of the balls.
     *
     * @return a list of the initial velocity of the balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * @return the speed of the paddle.
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     * @return the level of the name - to be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The method defines the Blocks for this level - each block contains its size, color and location.
     *
     * @return list of blocks.
     */
    List<Block> blocks();

    /**
     * The method returns the number of blocks that should be removed from the game.
     *
     * @return the number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}
