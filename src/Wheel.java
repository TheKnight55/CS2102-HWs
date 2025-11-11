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
        return String.format("%.1fkg, %.1f CL/kg", "", "");
    }
}
