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
        double seconds = battery.amountLeft/(propellers.currentDrawEach*propellers.count);
        double mTravelableOnBatteryLeft = seconds * propellers.speed;
        if (mTravelableOnBatteryLeft/metersToDest > 1) {
            return 1.0;
        } else {
            return mTravelableOnBatteryLeft/metersToDest;
        }
    }
    boolean doesReachDest() {
        double seconds = battery.amountLeft/(propellers.currentDrawEach*propellers.count);
        double metersCanTravel = seconds * propellers.speed;
        return metersCanTravel>=metersToDest;
    }
    String whichGoesFurther(MAV otherMAV) {
        double MAVseconds = battery.capacity/(propellers.currentDrawEach*propellers.count);
        double MAVdistance = MAVseconds * propellers.speed;
        double otherMAVseconds = otherMAV.battery.capacity/(otherMAV.propellers.currentDrawEach*otherMAV.propellers.count);
        double otherMAVdistance = otherMAVseconds * otherMAV.propellers.speed;
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
