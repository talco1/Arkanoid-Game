//319021457
package backgrounds;
import biuoop.DrawSurface;
import sprite.Sprite;
import java.awt.Color;
import java.awt.Polygon;

/**
 * Background of the first level of the game.
 */
public class FirstLevelBackground implements Sprite {
    //finals
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    static final int NUM_OF_STARS = 9;
    static final int FIRST_LINES = 7;
    static final int SECOND_LINES = 6;
    static final int RADIUS_MOON = 30;
    static final int FIRST_X_POINT = 100;
    static final int FIRST_Y_POINT = 100;
    static final int DIFFERENCE = 10;
    static final int SECOND_X_POINT = 50;
    static final int SECOND_Y_POINT = 150;
    static final int RECTANGLE_Y = 425;
    static final int RECTANGLE_X = 75;
    static final int NUM_OF_VERTICES = 3;
    static final int CIRCLE_X = 137;
    static final int CIRCLE_Y = 455;

    /**
     * Constructor.
     */
    public FirstLevelBackground() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(Color.WHITE);
        d.fillCircle(200, 150, RADIUS_MOON);
        d.setColor(Color.BLACK);
        d.fillCircle(230, 150, RADIUS_MOON);
        d.setColor(Color.WHITE);
        for (int i = 0; i < NUM_OF_STARS; i++) {
            d.drawLine(FIRST_X_POINT + (FIRST_X_POINT * i), FIRST_Y_POINT,
                    FIRST_X_POINT + (FIRST_X_POINT * i), FIRST_Y_POINT + DIFFERENCE);
            d.drawLine(FIRST_X_POINT - (DIFFERENCE / 2) + (FIRST_X_POINT * i), FIRST_Y_POINT + (DIFFERENCE / 2),
                    FIRST_Y_POINT + (DIFFERENCE / 2) + (FIRST_X_POINT * i), FIRST_Y_POINT + (DIFFERENCE / 2));
        }
        for (int i = 0; i < NUM_OF_STARS; i++) {
            d.drawLine(SECOND_X_POINT + (FIRST_X_POINT * i), SECOND_Y_POINT,
                    SECOND_X_POINT + (FIRST_X_POINT * i), SECOND_Y_POINT + DIFFERENCE);
            d.drawLine(SECOND_X_POINT - (DIFFERENCE / 2) + (FIRST_X_POINT * i),
                    SECOND_Y_POINT + (DIFFERENCE / 2), SECOND_X_POINT + (DIFFERENCE / 2) + (FIRST_X_POINT * i),
                    SECOND_Y_POINT + (DIFFERENCE / 2));
        }
        for (int i = 0; i < NUM_OF_STARS; i++) {
            d.drawLine(FIRST_X_POINT + (FIRST_X_POINT * i), (FIRST_Y_POINT * 2) + DIFFERENCE,
                    FIRST_X_POINT + (FIRST_X_POINT * i), (FIRST_Y_POINT * 2) + (DIFFERENCE * 2));
            d.drawLine(FIRST_X_POINT - (DIFFERENCE / 2) + (FIRST_X_POINT * i),
                    (FIRST_Y_POINT * 2) + (DIFFERENCE / 2) + DIFFERENCE,
                    FIRST_X_POINT + (DIFFERENCE / 2) + (FIRST_X_POINT * i),
                    (FIRST_Y_POINT * 2) + (DIFFERENCE / 2) + DIFFERENCE);
        }
        d.setColor(Color.GRAY);
        d.fillRectangle(FIRST_X_POINT, RECTANGLE_Y, RECTANGLE_X, FIRST_X_POINT);
        d.setColor(Color.GRAY.darker());
        d.fillRectangle(FIRST_X_POINT, RECTANGLE_Y, DIFFERENCE / 2, FIRST_X_POINT);
        int[] x1 = {FIRST_X_POINT, RECTANGLE_X + DIFFERENCE, FIRST_X_POINT};
        int[] y1 = {RECTANGLE_Y + DIFFERENCE, RECTANGLE_Y + FIRST_Y_POINT, RECTANGLE_Y + FIRST_Y_POINT - DIFFERENCE};
        d.fillPolygon(new Polygon(x1, y1, NUM_OF_VERTICES));
        d.fillRectangle(FIRST_X_POINT + RECTANGLE_X - (DIFFERENCE / 2), RECTANGLE_Y,
                DIFFERENCE / 2, FIRST_Y_POINT);
        int[] x2 = {FIRST_X_POINT + RECTANGLE_X, FIRST_X_POINT + (DIFFERENCE * 9), FIRST_X_POINT + RECTANGLE_X};
        int[] y2 = {RECTANGLE_Y + DIFFERENCE, RECTANGLE_Y + FIRST_Y_POINT, RECTANGLE_Y + FIRST_Y_POINT - DIFFERENCE};
        d.fillPolygon(new Polygon(x2, y2, NUM_OF_VERTICES));
        d.fillRectangle(FIRST_X_POINT, FIRST_Y_POINT + RECTANGLE_Y - (DIFFERENCE / 2),
                RECTANGLE_X, DIFFERENCE / 2);
        d.setColor(Color.GRAY.darker());
        d.fillCircle(CIRCLE_X, CIRCLE_Y, (DIFFERENCE * 2) + 2);
        d.setColor(Color.YELLOW.darker());
        d.fillCircle(CIRCLE_X, CIRCLE_Y, (DIFFERENCE * 2) - 2);
        d.setColor(Color.RED);
        int[] x = {FIRST_X_POINT, CIRCLE_X, FIRST_X_POINT + RECTANGLE_X};
        int[] y = {RECTANGLE_Y, FIRST_Y_POINT * 4, RECTANGLE_Y};
        int n = 3;
        d.fillPolygon(new Polygon(x, y, n));
        d.setColor(Color.GRAY.darker());
        d.fillRectangle(FIRST_X_POINT - (DIFFERENCE / 2), (FIRST_Y_POINT * 5) + (DIFFERENCE * 3) - 2,
                (DIFFERENCE * 8) + (DIFFERENCE / 2), DIFFERENCE);
        d.setColor(Color.GRAY.darker());
        d.fillRectangle(FIRST_X_POINT + (DIFFERENCE / 2), (FIRST_Y_POINT * 5) + (DIFFERENCE * 4) + 1,
                (DIFFERENCE * 6) + (DIFFERENCE / 2), DIFFERENCE);
        d.setColor(Color.YELLOW);
        for (int i = 0; i < FIRST_LINES; i++) {
            d.drawLine(FIRST_X_POINT + (DIFFERENCE / 2) + ((DIFFERENCE / 2) * i),
                    (FIRST_Y_POINT * 5) + (DIFFERENCE * 5) + 5,
                    FIRST_Y_POINT - DIFFERENCE  + ((DIFFERENCE / 2) * i),
                    (FIRST_Y_POINT * 6) + (DIFFERENCE * 9) + 5);
        }
        d.drawLine(FIRST_X_POINT + (DIFFERENCE * 4), (FIRST_Y_POINT * 5) + (DIFFERENCE * 5) + 5,
                FIRST_X_POINT + (DIFFERENCE * 4), (FIRST_Y_POINT * 6) + (DIFFERENCE * 9) + 5);
        for (int i = 0; i < SECOND_LINES; i++) {
            d.drawLine(FIRST_X_POINT + (DIFFERENCE * 4) + 5 + (5 * i),
                    (FIRST_Y_POINT * 5) + (DIFFERENCE * 5) + 5,
                    FIRST_X_POINT + (DIFFERENCE * 6)  + ((DIFFERENCE / 2) * i),
                    (FIRST_Y_POINT * 6) + (DIFFERENCE * 9) + 5);
        }
    }

    @Override
    public void timePassed() {
    }
}
