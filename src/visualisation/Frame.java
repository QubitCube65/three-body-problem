package visualisation;

//i never worked with this stuff
import javax.swing.JFrame;   //https://www.java-tutorial.org/jpanel.html - this old website is my main source

public class Frame extends JFrame {

    public Frame() {

        setTitle("Three body problem simulation:"); //title
        setSize(800,800); //size of the "canvas"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends all running processes if you close the window

    }
}