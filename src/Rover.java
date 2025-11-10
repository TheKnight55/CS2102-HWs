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
     *
     * @return
     */
    @Override
    public double percentUntilRecharge() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean doesReachDest() {
        double seconds = battery.getAmountLeft()/currentDraw();
        double metersCanTravel = seconds*findSpeed();
        return metersCanTravel>=findMetersToDest();
    }

    /**
     *
     * @return
     */
    protected double currentDraw() {
        double current=0;
        for (Wheel wheel:wheels) {
            current+=wheel.powerDraw();
        }
        return current;
    }

    /**
     *
     * @return
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
     *
     * @return
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
}
