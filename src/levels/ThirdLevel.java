//319021457
package levels;
import backgrounds.ThirdLevelBackground;
import game.Velocity;
import geometry.Point;
import geometry.Rectangle;
import objects.Block;
import sprite.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Third level - the third level of the game.
 */
public class ThirdLevel implements LevelInformation {
    //screen size and finals
    static final int ANGLE = 135;
    static final int SPEED = 5;
    static final int NUMBER_OF_BALLS = 2;
    static final int PADDLE_SPEED = 10;
    static final int PADDLE_WIDTH = 100;
    static final int NUMBER_OF_BLOCKS_TO_REMOVE = 40;
    static final int WIDTH_BLOCK = 50;
    static final int HEIGHT_BLOCK = 20;
    static final int FIRST_ROW = 6;
    static final int SECOND_ROW = 7;
    static final int THIRD_ROW = 8;
    static final int FOURTH_ROW = 9;
    static final int FIFTH_ROW = 10;
    static final int FIRST_X = 275;
    static final int FIRST_Y = 170;
    static final int PINK1 = 255;
    static final int PINK2 = 51;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            velocities.add(Velocity.fromAngleAndSpeed((ANGLE + (90 * i)), SPEED)); //2 balls
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new ThirdLevelBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        //create 40 blocks
        for (int i = 0; i < FIFTH_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y), WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, new Color(PINK1, PINK2, PINK2)));
        }
        for (int i = 0; i < FOURTH_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK + (WIDTH_BLOCK * i),
                    FIRST_Y + HEIGHT_BLOCK), WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, Color.PINK));
        }
        for (int i = 0; i < THIRD_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + (WIDTH_BLOCK * 2) + (WIDTH_BLOCK * i),
                    FIRST_Y + (HEIGHT_BLOCK * 2)), WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, Color.MAGENTA));
        }
        for (int i = 0; i < SECOND_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + (WIDTH_BLOCK * 3) + (WIDTH_BLOCK * i),
                    FIRST_Y + (HEIGHT_BLOCK * 3)), WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, Color.CYAN));
        }
        for (int i = 0; i < FIRST_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + (WIDTH_BLOCK * 4) + (WIDTH_BLOCK * i),
                    FIRST_Y + (HEIGHT_BLOCK * 4)), WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, Color.CYAN.darker()));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS_TO_REMOVE;
    }
}
