 package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.CowboyCharacter;
import game.myView;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {

    GetX gx = new GetX();
    private myView view;
    private CowboyCharacter cowboy;

    public Tracker(myView view, CowboyCharacter cowboy) {
        this.view = view;
        this.cowboy = cowboy;

    }

    public void preStep(StepEvent e) {
    }

    public void postStep(StepEvent e) {

        //Sets the view to track the player vertically, but not horizontally
        view.setCentre(new Vec2(cowboy.getPosition().sub(new Vec2(gx.getX(cowboy.getPosition()), -10.5f))));

    }
}
