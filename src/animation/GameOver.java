//319021457
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.Counter;

/**
 * Game Over class - to present a "game over" animation.
 */
public class GameOver implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * Constructor.
     * @param k a keyboard sensor.
     * @param score the score of the game.
     */
    public GameOver(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(250, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
