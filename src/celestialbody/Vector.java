package celestialbody;

/**
 * We need vectors for the representation of positions and velocity etc.
 */

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    //now some basic math for the vectors that is super important later:

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector multiply(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    //the length (or magnitude) of a vector: |vec|

    public double magnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    //the normalization of a vector: vec/|vec|

    public Vector normalize() {
        double magnitude = magnitude();
        return new Vector(x/magnitude, y/magnitude, z/magnitude);
    }
}
