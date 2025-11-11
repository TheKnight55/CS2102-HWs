import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Competition {
    List<Vehicle> vehicles;

    public Competition(List<Vehicle> vehicles) {
        this.vehicles=vehicles;
    }

    /**
     *
     * @param percent >= 0
     * @return count (int >= 0)
     */
    public int overThreshold(double percent) {
        int count=0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.percentUntilRecharge()>percent) {
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @return
     */
    public List<String> potentialWinners() {
        List<String> winners = new LinkedList<>();
        for (Vehicle vehicle: vehicles) {
            if (vehicle.doesReachDest()) {
                winners.add(vehicle.identifier());
            }
        }
        return winners;
    }

    /**
     *
     * @return
     */
    public String whoGoesFurthest() {
        return "";
    }
    public void simulateAll(double seconds) {

    }

    /**
     * Compares the two objects to determine if they're the same Competition
     * @param o the reference object with which to compare.
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Competition comp){
            return comp.vehicles.equals(this.vehicles);
        }
        return false;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return String.format("%.1fkg, %.1f CL/kg", "", "");
    }
}
