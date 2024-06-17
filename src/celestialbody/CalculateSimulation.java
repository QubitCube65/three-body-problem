package celestialbody;

import java.util.List;

public class CalculateSimulation {

    private List<Orb> celestialObjects;
    private double timeStep;

    public CalculateSimulation(List<Orb> celestialObjects, double timeStep) {

        this.celestialObjects = celestialObjects;
        this.timeStep = timeStep;
    }

    public List<Orb> getCelestialObjects() {
        return celestialObjects;
    }

    //the simulation of the whole thing sounds more tragic than it is:

    public void simulationProcess (double totalTime) {

        int simulationSteps = (int) (totalTime / timeStep);  //downcast necessary (for discrete time steps)

        for (int i = 0; i < simulationSteps; i++) {
            calculateForces();
            renewPositions();
        }
    }

    //now it gets kind of messy, but it is also beautiful:

    private void calculateForces() {

        double G = 6.67430e-11; //gravitation constant

        for(int i = 0; i < celestialObjects.size(); i++) {  //goes over the List of all celestial objects

            Orb orbA = celestialObjects.get(i);   //we take the i-th object
            Vector force = new Vector(0,0,0);  //we set the force to zero at the beginning

            //now the part of the interaction of the planets

            for (int j = 0; j < celestialObjects.size(); j++) { //we go over all the other objects (but not A)

                if(i != j) {

                Orb orbB = celestialObjects.get(j); //take j-th object
                Vector delta = orbB.getPosition().subtract(orbA.getPosition()); //calculate distance between the vectors
                double distance = delta.magnitude(); //calculate distance between the actual celestial objects
                double gForce = (G * orbA.getMass() * orbB.getMass()) / (distance * distance); //check README for Newtons
                                                                                           //gravity formula (m1*m2/r^2)
                force = force.add(delta.normalize().multiply(gForce)); //calculate resulting force and add it to the
                                                                       //force of orbA
                    System.out.println("Force magnitude: " + gForce + ", Distance: " + distance);
                }
            }
            Vector acceleration = force.multiply(1 / orbA.getMass()); //calculate acceleration of orbA

            orbA.setVelocity(orbA.getVelocity().add(acceleration.multiply(timeStep))); //thus: new speed of orbA
        }
    }

    private void renewPositions() {  //based on velocity and time steps

        for (Orb orb : celestialObjects) { //go over all celestial objects
            orb.setPosition(orb.getPosition().add(orb.getVelocity().multiply(timeStep)));
        }
    }
}