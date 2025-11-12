import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Rover implements Vehicle {
    int serialNum;
    List<Wheel> wheels;
    Battery battery;
    List<Double> wayPoints;
    public Rover(int serialNum, List<Wheel> wheels, Battery battery, List<Double> wayPoints) {
        this.serialNum=serialNum;
        this.wheels=wheels;
        this.battery=battery;
        this.wayPoints=wayPoints;
    }

    /**
     * Pretty-print out the rover identifier
     * @return the identifier in "Rover#%d" format
     */
    @Override
    public String identifier() {
        return String.format("Rover#%d",serialNum);
    }

    /**
     * Calculates the ratio of meters travelable on the rover's current battery to meters left to its destination.
     * If the ratio>=1, the method should produce 1.0.
     * @return the ratio between 0 to 1 inclusive, as a double
     */
    @Override
    public double percentUntilRecharge() {
        double seconds = battery.getAmountLeft()/currentDraw();
        double metersCanTravel = seconds*findSpeed();
        if (metersCanTravel/findMetersToDest() > 1) {
            return 1.0;
        } else {
            return metersCanTravel/findMetersToDest();
        }
    }

    /**
     * Determines whether the rover can reach the destination on its current battery’s amount left.
     * @return true if can reach dest, false if not
     */
    @Override
    public boolean doesReachDest() {
        double seconds = battery.getAmountLeft()/currentDraw();
        double metersCanTravel = seconds*findSpeed();
        return metersCanTravel>=findMetersToDest();
    }

    /**
     * Calculates the total current draw of all of the rover's wheels
     * @return the current draw in mA as a double
     */
    protected double currentDraw() {
        double current=0;
        for (Wheel wheel:wheels) {
            current+=wheel.powerDraw();
        }
        return current;
    }

    /**
     * Calculates the speed of the rover as the minimum speed of its wheels
     * @return the speed in m/s as a double
     */
    protected double findSpeed() {
        double min=wheels.get(0).speed();
        for (Wheel wheel:wheels) {
            if (min>wheel.speed()) {
                min=wheel.speed();
            }
        }
        return min;
    }

    /**
     * Finds the meters remaining until the destination is reached
     * @return the distance in meters as a double
     */
    protected double findMetersToDest() {
        double totalDistance=0;
        for (Double wayPoint: wayPoints) {
            totalDistance+=wayPoint;
        }
        return totalDistance;
    }

    /**
     * Moves the rover closer to the destination based on its leftover battery
     * @param seconds
     */
    @Override
    public void runFor(double seconds) {
        double metersCanTravel = seconds*findSpeed();
        reduceWayPoints(metersCanTravel);
        battery.reduceBy(seconds*currentDraw());
        if (battery.amountLeft<0) {
            battery.amountLeft=0;
        }
    }

    /**
     * Adjusts the wayPoints according to the given distance the rover can travel.
     * @param distance distance in meters (double>=0)
     */
    protected void reduceWayPoints(double distance) {
        List<Double> updatedPoints=new ArrayList<>();
        for (int i=0; i<wayPoints.size(); i++) {
            if (wayPoints.get(i)<=distance) {
                distance-=wayPoints.get(i);
            } else {
                updatedPoints.add(wayPoints.get(i)-distance);
                distance=0;
            }
        }
        wayPoints=new ArrayList<>(updatedPoints);
    }

    /**
     * Calculates how many meters the rover can travel on full battery capacity.
     * @return the number of meters as a double>=0
     */
    @Override
    public double metersOnFull() {
        double seconds = battery.getCapacity()/currentDraw();
        double metersCanTravel = seconds*findSpeed();
        return metersCanTravel;
    }

    /**
     * Determines whether or not the wayPoints of this rover are equal to the given wayPoints within 1 meter
     * @param newWayPoints wayPoints of the other rover to compare to
     * @return true if the wayPoints are equal and false otherwise
     */
    public boolean equalPoints(List<Double> newWayPoints) {
        for (int i=0; i<wayPoints.size(); i++) {
            if (!(Math.abs(wayPoints.get(i)-newWayPoints.get(i))<1)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Compares the two objects to determine if they're the same rover
     * @param o the reference object with which to compare.
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Rover rover) {
            return rover.serialNum==serialNum && rover.wheels.equals(wheels) && rover.battery.equals(battery) && rover.equalPoints(wayPoints);
        }
        return false;
    }
    /**
     * Prints out information about the rover
     * @return a String containing the serialNum, wheels, battery, and wayPoints of the rover in the format "%s, %s, %s, $s"
     */
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s", serialNum, wheels, battery, wayPoints);
    }
}
