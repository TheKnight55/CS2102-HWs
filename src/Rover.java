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
        return 0;
    }

    /**
     * Produces true if the rover can reach the destination on its current battery’s amount left.
     * Otherwise, it produces false.
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
            if (min<wheel.speed()) {
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
     *
     * @param seconds
     */
    @Override
    public void runFor(double seconds) {

    }

    /**
     *
     * @return
     */
    @Override
    public double metersOnFull() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return String.format("%s, %.1f CL/kg", "", "");
    }
}
