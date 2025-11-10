public class UUV implements Vehicle {
    String name;
    Propellers propellers;
    /**
     * Produces the name field of the UUV
     * @return this UUV's name as a String
     */
    @Override
    public String identifier() {
        return name;
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
        return false;
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
     * @param seconds
     */
    @Override
    public void runFor(double seconds) {

    }
}
