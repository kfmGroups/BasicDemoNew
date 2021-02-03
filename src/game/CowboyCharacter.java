package game;

import city.cs.engine.*;

public class CowboyCharacter extends Walker {

    private int healthCount; //used to answer 2nd requirement
    private static final int REDUCTION_AMOUNT = 20;

    //extends walker because the walker class represents a dynamic body which stands upright
    //the following code provides us with a cat image and the appropiate shape that matches the image
    private static final Shape shape = new PolygonShape(-0.67f,2.27f, -1.62f,0.93f, -1.03f,-2.47f, 1.27f,-2.44f, 1.58f,1.29f, 0.44f,2.43f);
    private static final BodyImage image = new BodyImage("data/cowboy.png",5.0f);
    //
    public CowboyCharacter(World world) {
        super(world, shape);//calling the constructor of walker to add the cat object to the world parameter
        addImage(image);
        healthCount = 100;
    }

    public int getHealthCount() {
        return healthCount;
    }

    public void incrementHealthCount(){
        if(healthCount == 100){
            System.out.println("health is at is maximum: "+healthCount);
        }else {
            healthCount++;
            System.out.println("health level increased");
        }

    }

    public void decrementHealthCount(){
        healthCount = healthCount - REDUCTION_AMOUNT;
        System.out.println("health level reduced by: "+REDUCTION_AMOUNT);

    }
}
