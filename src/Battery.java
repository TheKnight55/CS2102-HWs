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
     * Compares the two objects to determine if they're the same Competition
     * @param o the reference object with which to compare.
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Battery b){
            return b.capacity==capacity && b.amountLeft==amountLeft;
        }
        return false;
    }

        /**
     * Mutates the battery's amount left
     * based on the current being drawn from it * the amount of time the current is being drawn
     * @param currentSeconds current being drawn * time current is drawn
     */
    public void consumeBattery(double currentSeconds){
        this.amountLeft -= currentSeconds;
        if(this.amountLeft <= 0.0){
            this.amountLeft = 0.0;
        }
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
}
