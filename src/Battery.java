public class Battery {
    /** maximum power provided by the battery (when full) in milliAmpere-
    seconds (mAs or mA-s) */
    double capacity;
    /** current power providable by a battery in use in milliAmpere-
     seconds (mAs or mA-s) */
    double amountLeft;
    public Battery(double capacity, double amountLeft) {
        this.capacity=capacity;
        this.amountLeft=amountLeft;
    }
}
