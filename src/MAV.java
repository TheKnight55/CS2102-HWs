public class MAV {
    /** any identifier */
    String name;
    /** manages the propeller statistics */
    Propellers propellers;
    /** manages the battery statistics and state */
    Battery battery;
    /** how far it has left to go until it has reached a target in meters */
    double metersToDest;

    /**
     * The constructor for a MAV with no default assumptions
     * @param name is any identifier
     * @param propellers manages the propeller statistics
     * @param battery manages the battery statistics and state
     * @param metersToDest represents how far it has left to go until it has reached a target in meters
     */
    public MAV(String name, Propellers propellers, Battery battery, double metersToDest) {
        this.name = name;
        this.propellers = propellers;
        this.battery = battery;
        this.metersToDest = metersToDest;
    }

    /**
     * computes the ratio of meters travelable on its current battery’s amount left to meters until its destination.
     * If the vehicle can go past its destination, the method should produce 1.0.
     * @return the ratio
     */
    double percentUntilRecharge() {
        double seconds = propellers.findSeconds(battery.amountLeft);
        double mTravelableOnBatteryLeft = seconds * propellers.speed;
        if (mTravelableOnBatteryLeft/metersToDest > 1) {
            return 1.0;
        } else {
            return mTravelableOnBatteryLeft/metersToDest;
        }
    }

    /**
     * Produces true if the vehicle can reach the destination on its current battery’s amount left. 
     * Otherwise, it produces false.
     * @return true if can reach dest, false if not 
     */
    boolean doesReachDest() {
        double seconds = propellers.findSeconds(battery.amountLeft);
        double metersCanTravel = seconds * propellers.speed;
        return metersCanTravel>=metersToDest;
    }

     /**
     * Compares two vehicles and determines which can go further (in meters) on its full battery capacity.
     * @param otherMAV is the MAV being compared to this MAV
     * @return the name of the vehicle that can travel farther
     * If there is a tie (within 0.01 meters), it produces the names in the following format:
     * "thisVehiclesName&paramVehiclesName"
     */ 
    String whichGoesFurther(MAV otherMAV) {
        double MAVseconds = propellers.findSeconds(battery.capacity);
        double MAVdistance = propellers.findDistance(MAVseconds);
        double otherMAVseconds = otherMAV.propellers.findSeconds(otherMAV.battery.capacity);
        double otherMAVdistance = otherMAV.propellers.findDistance(otherMAVseconds);
        if (MAVdistance>otherMAVdistance) {
            return name;
        }
        else if (MAVdistance<otherMAVdistance) {
            return otherMAV.name;
        } else {
            return name+"&"+otherMAV.name;
        }
    }

      /**
     * Travels for the provided number of seconds at the speed of its propellers, moving the vehicle closer to its
     * destination and using its current amount of battery.
     * If the vehicle goes past its destination, metersToDest = 0, and if it needs more battery than is available
     * amountLeft = 0
     * @param seconds
     */
    void flyFor(double seconds) {
        double metersToTravel = seconds * propellers.speed; /** travels for number of seconds at the speed */
        metersToDest-=metersToTravel;
        if (metersToDest<0) {
            metersToDest=0.0;
        }
        double batterySpent = propellers.currentDrawEach*propellers.count;
        battery.amountLeft-=batterySpent*seconds;
        if (battery.amountLeft<0) {
            battery.amountLeft=0;
        }
    }
}
