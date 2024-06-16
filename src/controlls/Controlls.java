package controlls;

import celestialbody.CalculateSimulation;
import visualisation.DrawTrajectories;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlls {

    private CalculateSimulation calculateSimulation;
    private DrawTrajectories drawTrajectories;
    private Timer timer;


    public Controlls(CalculateSimulation calculateSimulation, DrawTrajectories drawTrajectories, Timer timer) {

        this.calculateSimulation = calculateSimulation;
        this.drawTrajectories = drawTrajectories;
        this.timer = new Timer(50, new ActionListener() { //every 50 milliseconds do this action
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSimulation.simulationProcess(0.05);  //simulation goes for a 0.05 step forward
                drawTrajectories.renewOrbs(calculateSimulation.getCelestialObjects());
            }
        });
    }

    public void beginSimulation() { //periodically updates the simulation of the trajectories
        timer.start();
    }
}
