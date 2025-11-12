/**
 * @author Emil Muzafarov
 * @author Cat Corapi
 */
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Examples {
    @Test
    public void testPercentUntilRecharge50Percent() {
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals(0.5, mav1.percentUntilRecharge(), 0.01);
    }
    @Test
    public void testRoverIdentifier() {
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1))),
                new Battery(10, 10),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
                assertEquals("Rover#7734", rover1.identifier());
    }
    @Test
    public void overThresholdMAVRoverTest(){
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(4,1,0.25),
                new Battery(10,10), 20);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,25), 20);
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1))),
                new Battery(60, 60),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        vehicles.add(rover1);
        Competition comp = new Competition(vehicles);
        assertEquals(2, comp.overThreshold(0.5), 0.01);
    }
    @Test
    public void overThresholdMAVTest(){
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(4,5,2.5),
                new Battery(10,1), 20);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,0), 20);
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(1.2, 0.5), new Wheel(1.2, 0.5), new Wheel(1.2, 0.5), new Wheel(1.2, 0.5))),
                new Battery(60, 20),
                new ArrayList<Double>(List.of(15.3, 2.4, 6.1, 1.6)));
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        Competition comp = new Competition(vehicles);
        assertEquals(0, comp.overThreshold(0.8), 0.01);
    }
    @Test
    public void overThresholdTest3(){
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(2,1,1.25),
                new Battery(10,10), 20);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        Competition comp = new Competition(vehicles);
        assertEquals(1, comp.overThreshold(0.25), 0.01);
    }
    @Test
    public void testSimulateAll() {
        MAV mav = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        Competition c = new Competition(List.of(mav));
        c.simulateAll(1); //run the competition for 1 second
        MAV mavAfter = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 9), 19);
        Competition cAfter = new Competition(List.of(mavAfter));
        assertEquals(cAfter, c);
    }
    @Test
    public void equalsTest(){
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(2,1,1.25),
                new Battery(10,10), 20);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        Competition comp = new Competition(vehicles);
        Competition comp2 = new Competition(vehicles);
        assertEquals(true, comp.equals(comp2));
    }
    @Test
    public void potentialWinnersTest() {
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(2,1,1.25),
                new Battery(10,10), 40);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1))),
                new Battery(60, 60),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        vehicles.add(rover1);
        Competition comp = new Competition(vehicles);
        assertEquals(List.of("firefly", "Rover#7734"), comp.potentialWinners());
    }
    @Test
    public void potentialWinnersEdgeCaseTest() {
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(2,1,1.25),
                new Battery(10,10), 40);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,0), 20);
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1))),
                new Battery(60, 60),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        vehicles.add(rover1);
        Competition comp = new Competition(vehicles);
        assertEquals(List.of("Rover#7734"), comp.potentialWinners());
    }
    @Test
    public void whichGoesFurthestRoverWinTest() {
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(2,1,1.25),
                new Battery(10,10), 40);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        Vehicle mav3 = new MAV("wasp",
                new Propellers(2,2.4,1.6),
                new Battery(40,40), 40);
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1))),
                new Battery(60, 60),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        vehicles.add(mav1);
        vehicles.add(mav2);
        vehicles.add(rover1);
        Competition comp = new Competition(vehicles);
        assertEquals("Rover#7734", comp.whoGoesFurthest());
    }
    @Test
    public void whichGoesFurthest2RoversTest() {
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(2,1,1.25),
                new Battery(10,10), 40);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        Vehicle mav3 = new MAV("wasp",
                new Propellers(2,2.4,1.6),
                new Battery(40,40), 40);
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1), new Wheel(4, 1))),
                new Battery(60, 60),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
        Vehicle rover2 = new Rover(3058,
                new ArrayList<>(List.of(new Wheel(10, 1), new Wheel(8, 1), new Wheel(8, 1))),
                new Battery(100, 30),
                new ArrayList<Double>(List.of(12.0, 22.5, 10.3, 8.9)));
        List<Vehicle> vehicles = new LinkedList<>();
        vehicles.add(mav1);
        vehicles.add(mav2);
        vehicles.add(mav3);
        vehicles.add(rover1);
        vehicles.add(rover2);
        Competition comp = new Competition(vehicles);
        assertEquals("Rover#3058", comp.whoGoesFurthest());
    }
    @Test
    public void whichGoesFurthestTieTest() {
        Vehicle mav1 = new MAV("bumblebee",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        Vehicle mav2 = new MAV("firefly",
                new Propellers(4,1,0.25),
                new Battery(30,28), 20);
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        Vehicle rover1 = new Rover(7734,
                new ArrayList<>(List.of(new Wheel(2, 1), new Wheel(2, 1), new Wheel(2, 1), new Wheel(2, 1))),
                new Battery(5, 5),
                new ArrayList<Double>(List.of(5.0, 5.0, 5.0, 5.0)));
        vehicles.add(mav1);
        vehicles.add(mav2);
        vehicles.add(rover1);
        Competition comp = new Competition(vehicles);
        assertEquals("firefly", comp.whoGoesFurthest());
    }
    @Test
    public void whichGoesFurthestNobodyTest() {
        List<Vehicle> vehicles = new LinkedList<>(); // empty
        Competition comp = new Competition(vehicles);
        assertEquals("Nobody", comp.whoGoesFurthest());
    }

//    @Test
//    public void testPercentUntilRecharge100Percent() {
//        Vehicle mav1 = new MAV("bumblebee2",
//                new Propellers(4, 2, 0.25),
//                new Battery(10, 10), 20);
//        assertEquals(1.0, mav1.percentUntilRecharge(), 0.01);
//    }
//
//    @Test
//    public void testDoesReachDestFalse() {
//        MAV mav1 = new MAV("bumblebee",
//                new Propellers(4, 1, 0.25),
//                new Battery(10, 10), 20);
//        assertEquals(false, mav1.doesReachDest());
//    }
//
//    @Test
//    public void testDoesReachDestTrue() {
//        MAV mav1 = new MAV("bumblebee2",
//                new Propellers(4, 2, 0.25),
//                new Battery(10, 10), 20);
//        assertEquals(true, mav1.doesReachDest());
//    }
//
//    @Test
//    public void testThisObjectGoesFurtherFirstWins() {
//        MAV mav1 = new MAV("bumblebee", new Propellers(4, 1, 0.25),
//                new Battery(10, 10), 20);
//        MAV mav2 = new MAV("firefly", new Propellers(4, 1, 0.25),
//                new Battery(2, 2), 20);
//        assertEquals("bumblebee", mav1.whichGoesFurther(mav2));
//    }
//
//    @Test
//    public void testThisObjectGoesFurtherBothEqual() {
//        MAV mav1 = new MAV("bumblebee", new Propellers(4, 1, 0.25),
//                new Battery(10, 10), 20);
//        MAV mav2 = new MAV("firefly", new Propellers(4, 1, 0.25),
//                new Battery(10, 10), 20);
//        assertEquals("bumblebee&firefly", mav1.whichGoesFurther(mav2));
//    }
//
//    @Test
//    public void testThisObjectGoesFurtherSecondWins() {
//        MAV mav1 = new MAV("bumblebee", new Propellers(4, 1, 0.25),
//                new Battery(2, 2), 20);
//        MAV mav2 = new MAV("firefly", new Propellers(4, 1, 0.25),
//                new Battery(10, 10), 20);
//        assertEquals("firefly", mav1.whichGoesFurther(mav2));
//    }
//
//    @Test
//    public void testFlyFor() {
//        MAV mav = new MAV("blue beetle", new Propellers(4, 1, 0.25),
//                new Battery(10, 10), 20);
//        mav.runFor(1);
//        assertEquals(9.0, mav.battery.amountLeft, 0.01);
//        assertEquals(19, mav.metersToDest, 0.01);
//    }
//
//    @Test
//    public void testFlyForOutOfJuice() {
//        MAV mav = new MAV("blue beetle", new Propellers(4, 1, 0.25),
//                new Battery(10, 0), 0);
//        mav.runFor(1);
//        assertEquals(0.0, mav.battery.amountLeft, 0.01);
//        assertEquals(0.0, mav.metersToDest, 0.01);
//    }
}