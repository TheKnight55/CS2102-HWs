import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Competition {
    List<Vehicle> vehicles;

    public Competition(List<Vehicle> vehicles) {
        this.vehicles=vehicles;
    }

    /**
     * Calculates the number of vehicles from the vehicles list that have percentUntilRecharge() greater than the given percentage
     * @param percent double>= 0
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
     * Creates a list of vehicle identifiers for vehicles that can reach their destination and win the race
     * @return a list of vehicle names (List<String>)
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
     * Determines which vehicles can travel the longest distance.
     * If there is a tie (within 0.01 meters), the vehicle that appears later in the list wins.
     * @return the identifier of the winning vehicle, or "Nobody" if the vehicles list is empty.
     */
    public String whoGoesFurthest() {
        String winner="Nobody";
        if (vehicles.size()>0) {
            double distance=vehicles.get(0).metersOnFull();
            for (Vehicle vehicle:vehicles) {
                if (vehicle.metersOnFull()>=distance) {
                    distance=vehicle.metersOnFull();
                    winner=vehicle.identifier();
                }
            }
        }
        return winner;
    }

    /**
     * Calls runFor() on each vehicle in the vehicles list for the given number of seconds.
     * @param seconds seconds to run for (double>=0)
     */
    public void simulateAll(double seconds) {
        for (Vehicle vehicle:vehicles) {
            vehicle.runFor(seconds);
        }
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
        return String.format("Vehicles: %s", vehicles);
    }
}
