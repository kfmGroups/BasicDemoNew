package game;

import city.cs.engine.*;

public class ZombieCharacter extends Walker {

    private int healthCount;

    //extends walker because the walker class represents a dynamic body which stands upright
    //the following code provides us with a Zombie character image and the appropriate shape that matches the image
    private static final Shape shape = new PolygonShape(-0.55f,1.97f, -1.4f,0.25f, -1.41f,-2.38f, 0.13f,-2.33f, 1.21f,0.22f, 1.01f,1.62f);
    private static final BodyImage image = new BodyImage("data/zombie.png",5.0f);


    public ZombieCharacter(World world) {
        super(world, shape);
        addImage(image);
        healthCount = 100;

    }
    public int getHealthCount() {
        return healthCount;
    }

    public void incrementHealthCount(){
        healthCount++;
    }

    public void decrementHealthCount(){
        healthCount--;
        System.out.println("health level reduced");
    }
}
