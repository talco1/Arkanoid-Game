//319021457
package game;

/**
 * A Counter class - a class used for counting things.
 */
public class Counter {
    //field
    private int counter;

    /**
     * Constructor.
     * @param counter the first value of the counter.
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * The method adds the number to the counter.
     *
     * @param number to add to the counter.
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * The method subtracts the number from current count.
     * @param number to decrease from the counter.
     */
    public void decrease(int number) {
        this.counter -= number;
    }
    // get current count.

    /**
     * @return the current value of the counter.
     */
    public int getValue() {
        return this.counter;
    }
}
