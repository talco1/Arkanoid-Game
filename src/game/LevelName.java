//319021457
package game;
import biuoop.DrawSurface;
import sprite.Sprite;
import java.awt.Color;

/**
 * Level Name - to present the name of the level on the screen.
 */
public class LevelName implements Sprite {
    private String name;

    /**
     * Constructor.
     * @param name the name of the level.
     */
    public LevelName(String name) {
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(580, 18, "Level Name: " + this.name, 15);
    }

    @Override
    public void timePassed() {
    }
}
