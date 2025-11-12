public class Wheel {
    double radius;
    double rps;
    public Wheel(double radius, double rps) {
        this.radius = radius;
        this.rps = rps;
    }

    /**
     * Calculates the speed of the wheel
     * @return the speed (m/s) as a double
     */
    double speed() {
        return rps*2*radius*Math.PI;
    }

    /**
     * Calculates the power draw of the wheel
     * @return the power draw in mA as a double
     */
    double powerDraw() {
        return rps*radius;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return String.format("%s m, %s rotations/s", radius, rps);
    }
    /**
     * Compares the two objects to determine if they're the same wheel
     * @param o the reference object with which to compare.
     * @return true if the wheel values are equal or false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Wheel w){
            return Math.abs(w.radius-this.radius)<0.01 && Math.abs(w.rps-this.rps)<0.01;
        }
        return false;
    }
}
