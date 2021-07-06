//319021457
package sprite;
import java.util.ArrayList;
import java.util.List;
import biuoop.DrawSurface;

/**
 * A sprite.SpriteCollection class - to save a list of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Constructor.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * The method adds a sprite to the array list.
     *
     * @param s the sprite to add to the list.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * The method removes a sprite from the array list.
     *
     * @param s the sprite to remove from the list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * The method notify all the sprites from the list that time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : spritesCopy) {
            s.timePassed();
        }
    }

    /**
     * The method draws all the sprites.
     *
     * @param d the draw surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
