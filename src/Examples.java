/**
 * @author Emil Muzafarov
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Examples {

    @Test
    public void testPercentUntilRecharge50Percent() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals(0.5, mav1.percentUntilRecharge(), 0.01);
    }

    @Test
    public void testPercentUntilRecharge100Percent() {
        MAV mav1 = new MAV("bumblebee2",
                new Propellers(4, 2, 0.25),
                new Battery(10, 10), 20);
        assertEquals(1.0, mav1.percentUntilRecharge(), 0.01);
    }

    @Test
    public void testDoesReachDestFalse() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals(false, mav1.doesReachDest());
    }

    @Test
    public void testDoesReachDestTrue() {
        MAV mav1 = new MAV("bumblebee2",
                new Propellers(4, 2, 0.25),
                new Battery(10, 10), 20);
        assertEquals(true, mav1.doesReachDest());
    }

    @Test
    public void testThisObjectGoesFurtherFirstWins() {
        MAV mav1 = new MAV("bumblebee", new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        MAV mav2 = new MAV("firefly", new Propellers(4, 1, 0.25),
                new Battery(2, 2), 20);
        assertEquals("bumblebee", mav1.whichGoesFurther(mav2));
    }

    @Test
    public void testThisObjectGoesFurtherBothEqual() {
        MAV mav1 = new MAV("bumblebee", new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        MAV mav2 = new MAV("firefly", new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals("bumblebee&firefly", mav1.whichGoesFurther(mav2));
    }

    @Test
    public void testThisObjectGoesFurtherSecondWins() {
        MAV mav1 = new MAV("bumblebee", new Propellers(4, 1, 0.25),
                new Battery(2, 2), 20);
        MAV mav2 = new MAV("firefly", new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals("firefly", mav1.whichGoesFurther(mav2));
    }

    @Test
    public void testFlyFor() {
        MAV mav = new MAV("blue beetle", new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        mav.flyFor(1);
        assertEquals(9.0, mav.battery.amountLeft, 0.01);
        assertEquals(19, mav.metersToDest, 0.01);
    }

    @Test
    public void testFlyForOutOfJuice() {
        MAV mav = new MAV("blue beetle", new Propellers(4, 1, 0.25),
                new Battery(10, 0), 0);
        mav.flyFor(1);
        assertEquals(0.0, mav.battery.amountLeft, 0.01);
        assertEquals(0.0, mav.metersToDest, 0.01);
    }

    @Test
    public void testFindDistance(){
        Propellers props = new Propellers(4,2.5,0.25);
        Battery bat = new Battery(10.0,5.0);
        assertEquals(12.5, props.findDistance(5.0), 0.01);

    }

    @Test
    public void testFindSeconds(){
        Propellers props = new Propellers(4,3,0.25);
        Battery bat = new Battery(10.0,6.0);
        assertEquals(6.0, props.findSeconds(bat.amountLeft), 0.01);

    }


}


