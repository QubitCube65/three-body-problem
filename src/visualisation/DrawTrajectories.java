package visualisation;

import celestialbody.Orb;
import celestialbody.Vector;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

/**
 * This class is determining how the drawn objects look like.
 */


public class DrawTrajectories extends JPanel{

    private List<Orb> celestialObjects;
    private List<List<Vector>> trajectories;  //list of list to save orbs structures
    private double scaleFactor = 1.4;
    private Map<Orb, Color> orbColors; //

    public DrawTrajectories(List<Orb> celestialObjects) {

        this.celestialObjects = celestialObjects;
        this.trajectories = new ArrayList<>();
        this.orbColors = new HashMap<>();

        Random rand = new Random();

        //always the same color is boring, and we also don't want to waste time choosing them
        for(Orb orb : celestialObjects) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            orbColors.put(orb, new Color(r,g,b));
            trajectories.add(new ArrayList<>());
        }
        setBackground(Color.BLACK);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) { //for some reason we need to override this
                                                //https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
        super.paintComponent(g);

        for(int i = 0; i < celestialObjects.size(); i++) {
            Orb orb = celestialObjects.get(i);
            trajectories.get(i).add(orb.getPosition());


        //draw the trajectories

        g.setColor(Color.WHITE);
        for(Vector position : trajectories.get(i)) {
            int x = (int) (position.getX() * scaleFactor + getWidth() / 2.0);
            int y = (int) (position.getY() * scaleFactor + getHeight() / 2.0);
            g.fillOval(x,y,2,2); //draws oval of size 2 at position xy
        }

        //draw the celestial objects

        Color orbColor = orbColors.get(orb);
        g.setColor(orbColor);
        int x = (int) (orb.getPosition().getX() * scaleFactor + getWidth() / 2.0);
        int y = (int) (orb.getPosition().getY() * scaleFactor + getHeight() / 2.0);
        g.fillOval(x,y,7,7);        //draws oval of size 5 at position xy

    }
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor (double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public void renewOrbs(List<Orb> orb) {
        this.celestialObjects = celestialObjects;
        repaint();
    }
}