//319021457
package animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Animation Runner class - in charge of the run loop of the game.
 */
public class AnimationRunner {
    //screen size
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //fields
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Constructor.
     */
    public AnimationRunner() {
        this.gui = new biuoop.GUI("Game", WIDTH, HEIGHT);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * @return the gui of the game.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * The method runs the animation object.
     *
     * @param animation the animation to run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            //creating the draw surface of the animation
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d); //one frame of the animation
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
