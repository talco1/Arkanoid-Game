//319021457
package levels;
import backgrounds.FirstLevelBackground;
import game.Velocity;
import geometry.Point;
import geometry.Rectangle;
import objects.Block;
import sprite.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * First level - the first level of the game.
 */
public class FirstLevel implements LevelInformation {
    //finals
    static final int ANGLE = 360;
    static final int SPEED = 7;
    static final int NUMBER_OF_BALLS = 1;
    static final int PADDLE_SPEED = 10;
    static final int PADDLE_WIDTH = 100;
    static final int SIZE = 30;
    static final int X_POINT = 385;
    static final int Y_POINT = 175;
    static final int NUMBER_OF_BLOCKS_TO_REMOVE = 1;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(Velocity.fromAngleAndSpeed(ANGLE, SPEED)); //1 ball
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new FirstLevelBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(new Block(new Rectangle(new Point(X_POINT, Y_POINT), SIZE, SIZE), Color.RED)); //1 block
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS_TO_REMOVE;
    }
}
