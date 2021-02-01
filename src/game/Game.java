package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;
import java.awt.*;


/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private World world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    /** Initialise a new Game. */

    private MovableCharacter character;

    public Game() {

        // make the world
        world = new World();

        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(world, shape);
        ground.setPosition(new Vec2(0, -11.5f));


        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(world, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));

        // add another platform here

        // make a character
        /*Shape studentShape = new PolygonShape(
                -0.11f,1.8f,
                0.87f,1.48f,
                0.99f,0.29f,
                0.24f,-2.32f,
                -1.12f,-2.27f,
                -1.24f,1.21f);
       // DynamicBody student = new DynamicBody(world, studentShape);*.

         */
         Shape professorShape = new PolygonShape(
                 0.7f,4.94f, -3.98f,3.64f, -0.88f,-4.68f, 2.96f,-4.88f, 3.68f,3.56f, 0.86f,4.98f);

        //add key 'a' to positive sign move forward
        //add key 'd' to negative move backwards
        //add key 'w' and 'space' to

       // student.setAlwaysOutline(true);

        // add more bodies here

        // make a view
        view = new MyView(world, 500, 500);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        view.setCharacter(new MovableCharacter(world, professorShape));
        MovableCharacter character = view.getCharacter();

        character.addImage(new BodyImage("data/professor.png", 10f));
        character.setPosition(new Vec2(8, -10));
        character.setAlwaysOutline(false);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        //view.addMouseListener(new MouseHandler(view));
        view.addKeyListener(new KeyHandler(view));
        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Basic world");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
        System.out.println("hello");
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
