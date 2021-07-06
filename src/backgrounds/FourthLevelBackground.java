//319021457
package backgrounds;
import biuoop.DrawSurface;
import sprite.Sprite;
import java.awt.Color;

/**
 * Background of the fourth level of the game.
 */
public class FourthLevelBackground implements Sprite {
    //finals
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    static final int NUM_OF_LINES = 15;
    static final int GRAY1 = 153;
    static final int GRAY2 = 204;
    static final int RADIUS1 = 20;
    static final int RADIUS2 = 25;
    static final int RADIUS3 = 30;
    static final int FIRST_X = 140;
    static final int FIRST_Y = 400;
    static final int SECOND_Y = 600;
    static final int DIFFERENCE = 5;
    static final int LENGTH = 100;

    /**
     * Background of the fourth level of the game.
     */
    public FourthLevelBackground() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.CYAN.darker());
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(Color.gray.brighter());
        for (int i = 0; i < NUM_OF_LINES; i++) {
            d.drawLine(FIRST_X + (i * 5), FIRST_Y, LENGTH + (DIFFERENCE * 5) + (i * 5), SECOND_Y); //up
            d.drawLine((LENGTH * 6) - (DIFFERENCE * 2) + (i * 5), (LENGTH * 4) + (DIFFERENCE * 10),
                    (LENGTH * 6) - (DIFFERENCE * 5) + (i * 5), SECOND_Y); //down
        }
        d.setColor(new Color(GRAY1, GRAY1, GRAY1).brighter());
        d.fillCircle(FIRST_X, (LENGTH * 4) - (DIFFERENCE * 2), RADIUS1); //up
        d.fillCircle(LENGTH + (DIFFERENCE * 10), (LENGTH * 4) + (DIFFERENCE * 3), RADIUS1); //up
        d.fillCircle((LENGTH * 6) - (DIFFERENCE * 2), (LENGTH * 4) + (DIFFERENCE * 8), RADIUS1); //down
        d.fillCircle(LENGTH * 6, (LENGTH * 5) - (DIFFERENCE * 7), RADIUS1); // down
        d.setColor(new Color(GRAY2, GRAY2, GRAY2));
        d.fillCircle((LENGTH * 2) - (DIFFERENCE * 7), (LENGTH * 4) - (DIFFERENCE * 3), RADIUS2); //up
        d.fillCircle((LENGTH * 6) + (DIFFERENCE * 3), (LENGTH * 4) + (DIFFERENCE * 7), RADIUS2); //down
        d.setColor(Color.GRAY.brighter());
        d.fillCircle(LENGTH * 2, LENGTH * 4, RADIUS3); //up
        d.fillCircle((LENGTH * 2) - (DIFFERENCE * 4), (LENGTH * 4) + (DIFFERENCE * 4), RADIUS1); //up
        d.fillCircle((LENGTH * 6) + (DIFFERENCE * 10), (LENGTH * 4) + (DIFFERENCE * 10), RADIUS3); //down
        d.fillCircle((LENGTH * 6) + (DIFFERENCE * 6), (LENGTH * 5) - (DIFFERENCE * 6), RADIUS1); //down
    }

    @Override
    public void timePassed() {

    }
}
