//319021457
package hits;

/**
 * A HitNotifier interface - objects that implement it send notifications when they are being hit.
 */
public interface HitNotifier {

    /**
     * The method adds a listener to hit events to the listeners lists.
     *
     * @param hl the listener to add.
     */
    void addHitListener(HitListener hl);

    /**
     * The method removes from the list of listeners to hit events.
     *
     * @param hl the listener to remove.
     */
    void removeHitListener(HitListener hl);
}
