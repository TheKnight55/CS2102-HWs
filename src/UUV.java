import java.util.List;

public class UUV implements Vehicle {
    String name;
    Propellers propellers;
    Battery battery;
    List<Double> checkPoints;
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
    /**
     * Compares the two objects to determine if they're the same Competition
     * @param o the reference object with which to compare.
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof UUV uuv){
            return uuv.name.equals(this.name);
        }
        return false;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return String.format("{%s | %s | %s}", "", "");
    }
}
