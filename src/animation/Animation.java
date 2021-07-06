//319021457
package animation;
import biuoop.DrawSurface;

/**
 * Animation interface - to handle the game-specific logic and stopping conditions of the animations.
 */
public interface Animation {

    /**
     * The method is in charge of the game logic - play one frame of the animation.
     *
     * @param d the draw surface of the game.
     */
    void doOneFrame(DrawSurface d);

    /**
     * The method is in charge of the stopping condition of the animation.
     *
     * @return boolean type, true - should stop, or false - should'nt stop.
     */
    boolean shouldStop();
}
