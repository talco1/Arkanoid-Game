//319021457
package objects;
import biuoop.DrawSurface;
import collide.Collidable;
import game.GameLevel;
import game.Velocity;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import hits.HitListener;
import hits.HitNotifier;
import sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A block class - to create a block, draw it and etc.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //fields
    private Rectangle rect;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * Constructor.
     * @param rect is the rectangle of the block
     * @param color is the color of the block
     */
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //the line is the intersection point
        Line l = new Line(collisionPoint, collisionPoint);
        //initializing new velocity to return it
        Velocity v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        if (l.isIntersecting(this.rect.getTopLine())) {
            v.setDy((v.getDy() * -1)); //the hit is on the top line of the block
        }
        if (l.isIntersecting(this.rect.getBottomLine())) {
            v.setDy((v.getDy() * -1)); //the hit is on the bottom line of the block
        }
        if (l.isIntersecting(this.rect.getRightLine())) {
            v.setDx((v.getDx() * -1)); //the hit is on the right line of the block
        }
        if (l.isIntersecting(this.rect.getLeftLine())) {
            v.setDx((v.getDx() * -1)); //the hit is on the left line of the block
        }
        this.notifyHit(hitter);
        return v;
    }

    /**
     * Draws the block on the given DrawSurface.
     *
     * @param surface the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        //drawing the block
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        //drawing the lines of the block
        surface.setColor(Color.BLACK); //sets black color for the line
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * Adding the block to the game.
     *
     * @param g the game to add the block to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Removing the block from the game.
     *
     * @param gameLevel the game to remove the block from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * The method notifies the listeners that a hit occurred.
     *
     * @param hitter the hitter ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
