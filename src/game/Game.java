package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;


/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameWorld world;

    /** A graphical display of the world (a specialised JPanel). */
    private myView view;

    private Animation animation;


    /** Initialise a new Game. */

  //  private MovableCharacter character;

    public Game() {

        // make the world
        world = new GameWorld();

        // make a view
        view = new myView(world, 500, 600);
        //view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
         //view.setGridResolution(1);



        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(view,world.getPlayer()));

        // used as a way of tracking the character.
        world.addStepListener(new Tracker(view, world.getPlayer()));

        //view
        // add the view to a frame (Java top level window)a
        final JFrame frame = new JFrame("Doodle Jump");
        frame.add(view);
        frame.addKeyListener(new CharacterController(world.getPlayer()));

        // enable the frame to quit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 600);

        // start our game world simulation!
        world.start();
        System.out.println("hello");
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
