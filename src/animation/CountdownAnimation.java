//319021457
package animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprite.SpriteCollection;
import java.awt.Color;

/**
 * Count down animation - to present count down before thr game starts.
 */
public class CountdownAnimation implements Animation {
    //screen size
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    static final int ZERO = 0;
    //fields
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int count;

    /**
     * Constructor.
     * @param numOfSeconds number of seconds to present the count down.
     * @param countFrom the number to start counting from.
     * @param gameScreen the screen to show on it the count.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.count = countFrom;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //stop counting
        if (countFrom == 0) {
            this.stop = true;
        }
        //drawing all the sprites and background
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        d.drawText(400, 400, Integer.toString(this.countFrom), 50); //show the countdown
        //timing
        if (this.countFrom != 3) {
            Sleeper sleeper = new Sleeper();
            int time = (int) (1000 * (numOfSeconds / count));
            sleeper.sleepFor(time - (1000 / 60));
        }
        this.countFrom--;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
