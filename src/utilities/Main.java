package utilities;

import controlls.Controlls;
import celestialbody.Orb;
import celestialbody.CalculateSimulation;
import visualisation.Frame;
import visualisation.DrawTrajectories;
import utilities.Reader;

import java.io.FileReader;
import java.util.List;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //get the input data

        List<Orb> celestialObjects = Reader.readCelestialObjects("input.txt");
        double timestep = 0.01;  //eg.
        double totalTime = 100; //eg.

        //initialise simulation

        CalculateSimulation calculateSimulation = new CalculateSimulation(celestialObjects, timestep);

        //graphics

        DrawTrajectories drawTrajectories = new DrawTrajectories(celestialObjects);
        Frame frame  = new Frame();
        frame.add(drawTrajectories);
        frame.setVisible(true);

        //simulate

        Timer timer = new Timer(1000, null);
        Controlls controlls = new Controlls(calculateSimulation, drawTrajectories, timer);
        controlls.beginSimulation();


    }
}
