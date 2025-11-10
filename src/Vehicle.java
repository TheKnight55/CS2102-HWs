
public interface Vehicle {
    String identifier();
    double percentUntilRecharge();
    boolean doesReachDest();
    double metersOnFull();
    void runFor(double seconds);
}
