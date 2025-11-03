public class MAV {
    String name;
    Propellers propellers;
    Battery battery;
    double metersToDest;
    public MAV(String name, Propellers propellers, Battery battery, double metersToDest) {
        this.name=name;
        this.propellers=propellers;
        this.battery=battery;
        this.metersToDest=metersToDest;
    }
    double percentUntilRecharge() {
        double seconds = propellers.findSeconds(battery.amountLeft);
        double mTravelableOnBatteryLeft = seconds * propellers.speed;
        if (mTravelableOnBatteryLeft/metersToDest > 1) {
            return 1.0;
        } else {
            return mTravelableOnBatteryLeft/metersToDest;
        }
    }
    boolean doesReachDest() {
        double seconds = propellers.findSeconds(battery.amountLeft);
        double metersCanTravel = seconds * propellers.speed;
        return metersCanTravel>=metersToDest;
    }
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
