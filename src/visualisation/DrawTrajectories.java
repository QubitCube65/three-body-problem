package visualisation;

import celestialbody.Orb;
import celestialbody.Vector;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


public class DrawTrajectories extends JPanel{

    private List<Orb> celestialObjects;
    private List<List<Vector>> trajectories;  //list of list to save orbs structures

    public DrawTrajectories(List<Orb> celestialObjects) {

        this.celestialObjects = celestialObjects;
        this.trajectories = new ArrayList<>();
        for (int i = 0;i < celestialObjects.size(); i++) {
            trajectories.add(new ArrayList<>());
        }
    }

    @Override
    protected void paintComponent(Graphics g) { //for some reason we need to override this
                                                //https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
        super.paintComponent(g);

        double scaleFactor = 0.7;

        for(int i = 0; i < celestialObjects.size(); i++) {
            Orb orb = celestialObjects.get(i);
            trajectories.get(i).add(orb.getPosition());


        //draw the trajectories

        g.setColor(Color.DARK_GRAY);
        for(Vector position : trajectories.get(i)) {
            int x = (int) (position.getX() * scaleFactor + getWidth() / 2.0);
            int y = (int) (position.getY() * scaleFactor + getHeight() / 2.0);
            g.fillOval(x,y,2,2); //draws oval of size 2 at position xy
        }

        //draw the celestial objects

        g.setColor(Color.MAGENTA);
        int x = (int) (orb.getPosition().getX() * scaleFactor + getWidth() / 2.0);
        int y = (int) (orb.getPosition().getY() * scaleFactor + getHeight() / 2.0);
        g.fillOval(x,y,7,7);        //draws oval of size 5 at position xy

    }
    }

    public void renewOrbs(List<Orb> orb) {
        this.celestialObjects = celestialObjects;
        repaint();
    }
}