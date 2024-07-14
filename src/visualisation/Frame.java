package visualisation;

//i never worked with this stuff
import javax.swing.JFrame;   //https://www.java-tutorial.org/jpanel.html - this old website is my main source
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.*;
import java.util.ArrayList;

/***
 * This class represents the frame/window in which the simulation
 * is visible with all its parameters.
 */

public class Frame extends JFrame {

    private DrawTrajectories drawTrajectories;

    public Frame(DrawTrajectories drawTrajectories) {

        this.drawTrajectories = drawTrajectories;

        setTitle("Three body problem simulation:"); //title
        setSize(800,800); //size of the "canvas"
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends all running processes if you close the window
        setVisible(true);

        //buttons for zooming in and out of the simulation:

        JButton zoomInButton = new JButton("+");
        zoomInButton.setPreferredSize(new Dimension(40, 20));
        zoomInButton.addActionListener(e -> {
            drawTrajectories.setScaleFactor(drawTrajectories.getScaleFactor() * 1.1);
            drawTrajectories.repaint();});

        JButton zoomOutButton = new JButton("-");
        zoomOutButton.setPreferredSize(new Dimension(40, 20));
        zoomOutButton.addActionListener(e -> {
            drawTrajectories.setScaleFactor(drawTrajectories.getScaleFactor() / 1.1);
            drawTrajectories.repaint();});

        getContentPane().add(drawTrajectories, BorderLayout.CENTER);
        getContentPane().add(zoomInButton, BorderLayout.NORTH);
        getContentPane().add(zoomOutButton, BorderLayout.SOUTH);
    }
}
