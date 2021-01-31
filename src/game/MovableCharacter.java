package game;

import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

public class MovableCharacter extends Walker {
    public MovableCharacter(World world) {
        super(world);
    }


    public MovableCharacter(World world, Shape shape) {
        super(world, shape);
    }
}
