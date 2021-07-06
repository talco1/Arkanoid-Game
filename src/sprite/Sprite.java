//319021457
package sprite;
import biuoop.DrawSurface;

/**
 * sprite.Sprite interface - every sprite object implements this interface.
 */
public interface Sprite {

    /**
     * The method draws the sprite object.
     *
     * @param d the draw surface to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * The method notify the sprite that time has passed.
     */
    void timePassed();
}
