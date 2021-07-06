//319021457
package levels;
import backgrounds.SecondLevelBackground;
import game.Velocity;
import geometry.Point;
import geometry.Rectangle;
import objects.Block;
import sprite.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Second level - the second level of the game.
 */
public class SecondLevel implements LevelInformation {
    //finals
    static final int ANGLE = 135;
    static final int SPEED = 5;
    static final int NUMBER_OF_BALLS = 10;
    static final int PADDLE_SPEED = 10;
    static final int PADDLE_WIDTH = 600;
    static final int FIRST_X_POINT = 725;
    static final int Y_POINT = 250;
    static final int WIDTH_BLOCK = 50;
    static final int NUMBER_OF_BLOCKS_TO_REMOVE = 15;
    static final int HEIGHT_BLOCK = 20;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(ANGLE + (10 * i), SPEED)); //10 balls
        }
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
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new SecondLevelBackground();
    }

    @Override
    public List<Block> blocks() {
        //one row of blocks with random color.
        Random rand = new Random();
        List<Block> blocks = new ArrayList<Block>();
        for (int i = 0; i < NUMBER_OF_BLOCKS_TO_REMOVE; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X_POINT - WIDTH_BLOCK * i, Y_POINT),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            Color randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            blocks.add(new Block(rect, randomColor));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS_TO_REMOVE;
    }
}
