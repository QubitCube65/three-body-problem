package visualisation;

import celestialbody.Orb;

import java.util.List;
import javax.swing.JPanel;
import java.awt.Graphics;


public class DrawTrajectories {

    private List<Orb> celestialObjects;

    public DrawTrajectories() {
        this.celestialObjects = celestialObjects;
    }

    @Override
    protected void paintComponent(Graphics g) { //for some reason we need to override this
                                                //https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
        super.paintComponent(g);

        for (Orb orb : celestialObjects) {
            int x = (int) orb.getPosition().getX();
            int y = (int) orb.getPosition().getY();
            g.fillOval(x,y,5,5);
        }
    }

    public void renewOrbs(Orb orb) {
        this.celestialObjects = celestialObjects;
        repaint();
    }
}
