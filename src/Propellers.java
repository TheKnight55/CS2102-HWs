public class Propellers {
    /** the number of propellers on the unit  */
    int count;
    /** speed of the propeller in meters/secs */
    double speed;
    /** milliAmpere-per-propeller (mA/#propellers) */
    double currentDrawEach;
    public Propellers(int count, double speed, double currentDrawEach) {
        this.count = count;
        this.speed = speed;
        this.currentDrawEach = currentDrawEach;
    }
    double findDistance(double seconds) {
        return seconds*speed;
    }
    double findSeconds(double batteryAmount) {
        return batteryAmount/(currentDrawEach*count);
    }
}
