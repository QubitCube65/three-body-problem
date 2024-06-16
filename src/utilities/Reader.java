package utilities;

import celestialbody.Orb;
import celestialbody.Vector;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {

    public static List<Orb> readCelestialObjects (String filename) {   //read celestial objects from a file

        List<Orb> celestialObjects = new ArrayList<>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filename))) { //BufferedReader reads all lines
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");

                double mass = Double.parseDouble(parts[0]);
                Vector position = new Vector(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                Vector velocity = new Vector(Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
                celestialObjects.add(new Orb(mass, position, velocity)); //new Orb object gets added to the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return celestialObjects; //returns the list with the read in celestial objects
    }
}