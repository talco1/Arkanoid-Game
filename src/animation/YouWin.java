//319021457
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.Counter;

/**
 * You Win - to present a "You Win" animation in the end of the game.
 */
public class YouWin implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * Constructor.
     * @param k a keyboard sensor.
     * @param score the score of thr game.
     */
    public YouWin(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(250, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}