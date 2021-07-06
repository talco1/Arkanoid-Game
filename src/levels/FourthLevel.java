//319021457
package levels;
import backgrounds.FourthLevelBackground;
import game.Velocity;
import geometry.Point;
import geometry.Rectangle;
import objects.Block;
import sprite.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Fourth level - the fourth level of the game.
 */
public class FourthLevel implements LevelInformation {
    //screen size and finals
    static final int ZERO = 0;
    static final int ANGLE = 135;
    static final int SPEED = 5;
    static final int NUMBER_OF_BALLS = 3;
    static final int PADDLE_SPEED = 10;
    static final int PADDLE_WIDTH = 100;
    static final int NUMBER_OF_BLOCKS_TO_REMOVE = 105;
    static final int WIDTH_BLOCK = 50;
    static final int HEIGHT_BLOCK = 25;
    static final int BLOCKS_IN_ROW = 15;
    static final int FIRST_X = 25;
    static final int FIRST_Y = 150;
    static final int COLOR1 = 255;
    static final int COLOR2 = 204;
    static final int COLOR3 = 80;
    static final int COLOR4 = 102;
    static final int COLOR5 = 51;
    static final int COLOR6 = 153;

    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<Velocity>();
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            velocities.add(Velocity.fromAngleAndSpeed((ANGLE + (45 * i)), SPEED)); //3 balls
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new FourthLevelBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<Block>();
        //create 105 blocks
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y), WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, Color.pink));
        }
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y + HEIGHT_BLOCK),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, Color.RED));
        }
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y + (HEIGHT_BLOCK * 2)),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, new Color(COLOR1, COLOR2, ZERO)));
        }
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y + (HEIGHT_BLOCK * 3)),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, new Color(COLOR1, COLOR1, COLOR3)));
        }
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y + (HEIGHT_BLOCK * 4)),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, new Color(COLOR4, COLOR1, COLOR4)));
        }
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y + (HEIGHT_BLOCK * 5)),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, new Color(COLOR5, COLOR6, COLOR1)));
        }
        for (int i = 0; i < BLOCKS_IN_ROW; i++) {
            Rectangle rect = new Rectangle(new Point(FIRST_X + WIDTH_BLOCK * i, FIRST_Y + (HEIGHT_BLOCK * 6)),
                    WIDTH_BLOCK, HEIGHT_BLOCK);
            blocks.add(new Block(rect, new Color(COLOR4, ZERO, COLOR6)));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS_TO_REMOVE;
    }
}
