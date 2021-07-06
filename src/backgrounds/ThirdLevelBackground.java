//319021457
package backgrounds;
import biuoop.DrawSurface;
import sprite.Sprite;
import java.awt.Color;

/**
 * Background of the third level of the game.
 */
public class ThirdLevelBackground implements Sprite {
    //finals
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    static final int R = 5;
    static final int X = 100;
    static final int Y = 300;
    static final int WIDTH_REC = 25;
    static final int HEIGHT_REC = 75;
    static final int DIFFERENCE = 10;

    /**
     * Constructor.
     */
    public ThirdLevelBackground() {

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.PINK.darker());
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        d.setColor(Color.RED);
        d.fillRectangle(X, Y, X + WIDTH_REC, X + HEIGHT_REC);
        d.setColor(Color.WHITE);
        d.fillRectangle(X, Y + 125, X + WIDTH_REC, DIFFERENCE * 2);
        d.setColor(Color.GREEN.darker());
        d.fillRectangle(X, Y + 145, X + WIDTH_REC, DIFFERENCE * 3);
        d.setColor(Color.orange.darker());
        d.fillRectangle(X + (DIFFERENCE * 5) - 3, Y + X + HEIGHT_REC, DIFFERENCE * 3, DIFFERENCE * 7);
        d.setColor(Color.BLACK);
        d.fillCircle(X + (DIFFERENCE * 5), Y + WIDTH_REC, R);
        d.fillCircle(X + (DIFFERENCE * 2), Y + DIFFERENCE, R);
        d.fillCircle(X + WIDTH_REC, Y + DIFFERENCE * 4 + 5, R);
        d.fillCircle(X * 2, Y + DIFFERENCE * 4 + 5, R);
        d.fillCircle(X * 2 + DIFFERENCE + 5, Y + DIFFERENCE + 5, R);
        d.fillCircle(X + DIFFERENCE * 6, X * 4, R);
        d.fillCircle(X + DIFFERENCE, X * 4 + DIFFERENCE + 5, R);
        d.fillCircle(X * 2, Y + (DIFFERENCE * 8), R);
        d.fillCircle(X + WIDTH_REC, Y + (DIFFERENCE * 8), R);
        d.fillCircle(X + (DIFFERENCE * 6) + 5, Y + (DIFFERENCE * 6), R);
        d.fillCircle((X * 2) + DIFFERENCE, (X * 4) + DIFFERENCE, R);
        d.fillCircle(X + (DIFFERENCE * 8) + 5, Y + (DIFFERENCE * 2), R);
    }

    @Override
    public void timePassed() {

    }
}
