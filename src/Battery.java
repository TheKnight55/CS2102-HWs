public class Battery {
    /** maximum power provided by the battery (when full) in milliAmpere-
     seconds (mAs or mA-s) */
    double capacity;

    /** current power providable by a battery in use in milliAmpere-
     seconds (mAs or mA-s) */
    double amountLeft;

    /**
     * The constructor for a battery assuming it can draw any amount of current without exploding
     * @param capacity is the maximum power provided by the battery (when full) in milliAmpere-
     * seconds (mAs or mA-s)
     * @param amountLeft is the current power providable by a battery in use in milliAmpere-seconds
     * (mAs or mA-s)
     */
    public Battery(double capacity, double amountLeft) {
        this.capacity = capacity;
        this.amountLeft = amountLeft;
    }
    /**
     * getter for amountLeft
     * @return the amount of battery life left in mAs (double)
     */
    double getAmountLeft() {
        return amountLeft;
    }
    /**
     * getter for capacity
     * @return capacity of the battery in mAs (double)
     */
    double getCapacity() {
        return capacity;
    }
}
