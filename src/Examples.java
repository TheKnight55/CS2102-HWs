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
    public void testPercentUntilRechargeOver100Percent() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 3.2, 0.4),
                new Battery(10, 30), 50);
        assertEquals(1, mav1.percentUntilRecharge(), 0.01);
    }
    @Test
    public void testToDestNotReached() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 1, 0.25),
                new Battery(10, 10), 20);
        assertEquals(false, mav1.doesReachDest());
    }
    @Test
    public void testToDestReached() {
        MAV mav1 = new MAV("butterfly",
                new Propellers(4, 3.2, 0.4),
                new Battery(10, 30), 50);
        assertEquals(true, mav1.doesReachDest());
    }
    @Test
    public void testThisObjectGoesFurther() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 3, 0.25),
                new Battery(10, 30), 100);
        MAV mav2 = new MAV("firefly",
                new Propellers(2, 1, 0.2),
                new Battery(10, 50), 100);
        assertEquals("bumblebee", mav1.whichGoesFurther(mav2));
    }
    @Test
    public void testSecondObjectGoesFurther() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 3, 0.25),
                new Battery(10, 30), 100);
        MAV mav2 = new MAV("firefly",
                new Propellers(2, 1, 0.2),
                new Battery(10, 50), 100);
        assertEquals("bumblebee", mav2.whichGoesFurther(mav1));
    }
    @Test
    public void testNoneGoesFurther() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 3, 0.25),
                new Battery(10, 30), 100);
        MAV mav2 = new MAV("firefly",
                new Propellers(4, 3, 0.25),
                new Battery(10, 50), 100);
        assertEquals("bumblebee&firefly", mav1.whichGoesFurther(mav2));
    }
    @Test
    public void testflyFor() {
        MAV mav1 = new MAV("bumblebee",
                new Propellers(4, 3, 0.25),
                new Battery(10, 30), 100);
        mav1.flyFor(60);
        assertEquals(0.0, mav1.metersToDest, 0.01);
        assertEquals(0.0, mav1.battery.amountLeft, 0.01);
    }
}