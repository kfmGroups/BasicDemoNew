package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private static final float RADIUS = 1f;


    private static final Shape  shape = new CircleShape(1);

    private static final BodyImage ballImage
            = new BodyImage("data/redBall.png", 2.0f);

    private WorldView view;
    private CowboyCharacter character;

    public MouseHandler(WorldView view, CowboyCharacter character) {
        this.view = view;
        this.character = character;

    }

    /**
     * Create a bowling ball at the current mouse position.
     * @param e event object containing the mouse position
     */
    public void mousePressed(MouseEvent e) {


        //now each ball has a collision listener thus whenever the ball collides with another object collision occurs
        //ball.setAlwaysOutline(true);

         Shape shape = new CircleShape(1);

        Body ball = new RedBallCharacter(view.getWorld());
        ball.addImage(ballImage);
        ball.addCollisionListener(new CollisionEngine(character));
        ball.setPosition(view.viewToWorld(e.getPoint()));

    }
}
