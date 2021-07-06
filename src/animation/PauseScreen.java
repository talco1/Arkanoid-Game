//319021457
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Pause screen animation - to pause the game.
 */
public class PauseScreen implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Constructor.
     * @param k a keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
