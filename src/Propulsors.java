public class Propulsors {
    /** the number of propellers on the unit  */
    int count;
    /** force of the propeller in Newtons */
    double force;
    /** milliAmpere-per-propulsor] (mA/#propellers) */
    double currentDrawEach;
    /** mass of the unit in kgs */
    double mass;
    /**
     * The constructor for a propeller with no default assumptions
     * @param count is the number of propellers on the propeller unit (1, 2, 3, 4, etc.)
     * @param force is how fast the unit can go in meters-per-second
     * @param currentDrawEach is how much power each propeller consumes when turned on in
     * milliAmpere-per-propeller.
     */
    public Propulsors(int count, double force, double currentDrawEach, double mass) {
        this.count = count;
        this.force = force;
        this.currentDrawEach = currentDrawEach;
        this.mass=mass;
    }
    /**
     *
     * @param seconds
     * @return
     */
    protected double findAcceleration(double seconds) {
        return seconds*force/mass;
    }

    /**
     *
     * @return
     */
    double totalCurrent() {
        return currentDrawEach*count;
    }

    /**
     *
     * @param o   the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Propulsors p){
            return p.count==this.count && Math.abs(p.force-force)<0.01 && Math.abs(p.currentDrawEach-this.currentDrawEach)<0.01 && Math.abs(p.mass-this.mass)<0.01;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return String.format("%s, %s N, %s mA/propulsors, %s kgs", count, force, currentDrawEach, mass);
    }
}
