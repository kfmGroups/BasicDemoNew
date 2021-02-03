package game;

import city.cs.engine.UserView;
import city.cs.engine.Walker;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterController extends KeyAdapter {

    //logic for controlling the cowboy is in Character controller
    private static final float JUMPING_VALUE = 12;
    private static final float WALKING_SPEED_VALUE = 4;

    //we want this body to refer to the cowboy
    private Walker body;

    public CharacterController(Walker body) {
        this.body = body;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }


    /*handle key pressesd of the form awd*/
    @Override
    public void keyPressed(KeyEvent e) {


//     Converting the key code all to lowercase to make sure 'W' and 'w' both work as an input
        switch (Character.toLowerCase(e.getKeyChar())) {
            case 'w':
                body.jump(JUMPING_VALUE);
                break;

            case 'a':
                body.startWalking(-WALKING_SPEED_VALUE);
                break;

            case 'd':
                body.startWalking(WALKING_SPEED_VALUE);
                break;

            default:
                //System.out.println("wrong Key");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        super.keyReleased(e);
        switch (Character.toLowerCase(e.getKeyChar())) {

            case 'a':
            case 'd':
                body.stopWalking();
                break;
            default:
                //System.out.println("wrong Key");
                break;
        }
    }
}
