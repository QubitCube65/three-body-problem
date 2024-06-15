package celestialbody;

/** *
 * This class represents a celestial body like a planet, star etc.
 * with its basic values that everyone has.
 */

public class Orb {

    private double mass;
    private Vector position;
    private Vector velocity;

    public Orb(double mass, Vector position, Vector velocity) {

        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
    }

    //getter and setter

    public double getMass() {
        return mass;
    }

    public Vector getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    // no setter for mass because we assume it stays the same
}
