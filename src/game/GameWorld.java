package game;

/*A game world is a world with some bodies*/

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GameWorld extends World {
    //todo make into an array for faster cmputation
    private Image background;
    private CowboyCharacter cowboy;
    private ZombieCharacter zombie;

    public GameWorld(){
        super();

        //make the ground
        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape); //referring to an object of this class
        ground.setPosition(new Vec2(0, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 5.5f));
        Body platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5,-2.5f));

        // make a character
        cowboy = new CowboyCharacter(this);
        cowboy.setPosition(new Vec2(4,-10));
        cowboy.setAlwaysOutline(true);
        zombie = new ZombieCharacter(this);
        zombie.setPosition(new Vec2(-9, 6));
        zombie.setAlwaysOutline(true);
        zombie.addCollisionListener(new CollisionEngine(cowboy));

        for (int i = 0; i < 10; i++){
            //redBalls increase the health count of a character
            Body redBall = new RedBallCharacter(this);
            redBall.setPosition(new Vec2(i*2-10,10));
            redBall.setAlwaysOutline(true);
            //now each ball has a collision listener thus whenever the ball collides with another object collision occurs
            redBall.addCollisionListener(new CollisionEngine(cowboy));
        }


    }

    //@Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(background,0,0, (ImageObserver) this);
    }

    public CowboyCharacter getPlayer(){
        return cowboy;
    }
}
