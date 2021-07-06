//319021457
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * KeyPressStoppableAnimation - a decorator-class to wrap an animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private String key;
    private boolean stop;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     * @param sensor a keyboard sensor.
     * @param key the specific key to wait for.
     * @param animation the animation to add a "waiting-for-key" behavior to it.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d); //do one frame of the animation
        if (this.keyboard.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        }
        if (!this.keyboard.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
