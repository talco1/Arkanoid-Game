//319021457
package backgrounds;
import biuoop.DrawSurface;
import sprite.Sprite;
import java.awt.Color;

/**
 * Background of the first level of the game.
 */
public class SecondLevelBackground implements Sprite {
    //finals
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    static final int NUM_OF_LINES = 75;
    static final int X = 150;
    static final int Y = 125;
    static final int END_Y = 250;
    static final int END_X = 25;
    static final int FIRST_R = 60;
    static final int SECOND_R = 50;
    static final int THIRD_R = 70;
    static final int GOLD1 = 255;
    static final int GOLD2 = 204;
    static final int GOLD3 = 51;

    /**
     * Constructor.
     */
    public SecondLevelBackground() {

    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE.darker());
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(new Color(GOLD1, GOLD2, GOLD3)); //gold
        for (int i = 0; i < NUM_OF_LINES; i++) {
            d.drawLine(X, Y, END_X + (10 * i), END_Y);
        }
        d.setColor(new Color(GOLD1, GOLD2, GOLD3)); //gold
        d.fillCircle(X, Y, THIRD_R);
        d.setColor(Color.ORANGE);
        d.fillCircle(X, Y, FIRST_R);
        d.setColor(Color.YELLOW);
        d.fillCircle(X, Y, SECOND_R);
    }

    @Override
    public void timePassed() {
    }
}
