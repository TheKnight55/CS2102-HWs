public class Propellers {
    /** the number of propellers on the unit  */
    int count;
    /** speed of the propeller in meters/secs */
    double speed;
    /** milliAmpere-per-propeller (mA/#propellers) */
    double currentDrawEach;

    /**
     * The constructor for a propeller with no default assumptions
     * @param count is the number of propellers on the propeller unit (1, 2, 3, 4, etc.)
     * @param speed is how fast the unit can go in meters-per-second
     * @param currentDrawEach is how much power each propeller consumes when turned on in
     * milliAmpere-per-propeller.
     */
    public Propellers(int count, double speed, double currentDrawEach) {
        this.count = count;
        this.speed = speed;
        this.currentDrawEach = currentDrawEach;
    }

     /**
     * Multiplies the time it can run on its current battery by the speed 
     * to get the distance it can travel on its current battery (s * m/s = m) 
     * @param seconds amount of seconds the MAV can run on its current battery (can use findSeconds)
     * @return the total distance it can travel on its current batter in meters
     */
    protected double findDistance(double seconds) {
        return seconds*speed;
    }

    /**
     * Divides the battery amount left by the collective static current drawn by the propellers (mA-s/mA)
     * @param batteryAmount batteryLeft on this battery (mA-s)
     * @return the total amount of seconds the MAV can run on its current battery
     */
    protected double findSeconds(double batteryAmount) {
        return batteryAmount/(currentDrawEach*count);
    }
}
