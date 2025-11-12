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
    /**
     * Computes the amount of time in seconds the battery can last starting from its current capactiy
     * @param currentDraw is the current being drawn from the battery in mA
     * @return the amount of seconds the battery can last on its current capacity
     */
    public double secondsOnLeft(double currentDraw){
        return this.amountLeft / currentDraw;
    }
    /**
     * Computes the amount of time in seconds the battery can last starting from its full capactiy
     * @param currentDraw is the current being drawn from the battery in mA
     * @return the amount of seconds the battery can last on its full capacity
     */
    public double secondsOnFull(double currentDraw){
        return this.capacity / currentDraw;
    }
    /**
     * Reduces the battery left by the given value.
     * If the remaining battery<0, set amount left to 0
     * @param amt amount of battery spent as a double
     */
    public void reduceBy(double amt) {
        amountLeft-=amt;
        if (amountLeft<0) {
            amountLeft=0;
        }
    }
    /**
     * Compares the two objects to determine if they're the same Battery
     * @param o the reference object with which to compare.
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Battery b){
            return Math.abs(b.capacity-capacity)<0.01 && Math.abs(b.amountLeft-amountLeft)<0.01;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s, %s", capacity, amountLeft);
    }
}
