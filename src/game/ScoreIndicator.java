//319021457
package game;

import biuoop.DrawSurface;
import sprite.Sprite;
import java.awt.Color;

/**
 * A ScoreIndicator class -  in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    //finals
    static final int TEXT_SIZE = 15;
    static final int X_TEXT = 300;
    static final int Y_TEXT = 18;
    static final int ZERO = 0;
    static final int WIDTH = 800;
    static final int HEIGHT = 20;

    //field
    private Counter score;

    /**
     * Constructor.
     * @param score the current score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }
    @Override
    public void drawOn(DrawSurface d) {
        //display the rectangle
        d.setColor(Color.GRAY.brighter());
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT);
        //display the score
        d.setColor(Color.BLACK);
        d.drawText(X_TEXT, Y_TEXT, "Score:" + this.score.getValue(), TEXT_SIZE);
    }

    @Override
    public void timePassed() {
    }
}
