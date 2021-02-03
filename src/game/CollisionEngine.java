package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CollisionEngine implements CollisionListener {
    private CowboyCharacter cowboy;

    public CollisionEngine(CowboyCharacter character){
        cowboy = character;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        //other body represents what the ball collided with
        System.out.println();
        if(collisionEvent.getReportingBody() instanceof RedBallCharacter && collisionEvent.getOtherBody() == cowboy){
            System.out.println("Collision has occured between healthBall and Cowboy");
            cowboy.incrementHealthCount();
            //reporting body represents the object which has had an object collided with it
            collisionEvent.getReportingBody().destroy();//get the ball in question and destroy it
        }else if (collisionEvent.getReportingBody() instanceof ZombieCharacter && collisionEvent.getOtherBody() == cowboy){
            System.out.println("Collision has occured between Cowboy and Zombie");
            cowboy.decrementHealthCount();
            collisionEvent.getReportingBody().destroy();
        }

    }
}
