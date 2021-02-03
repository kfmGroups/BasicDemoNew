package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class myView extends city.cs.engine.UserView {
    private Image background;

    private MovableCharacter character;
    private Animation animation;
    BufferedImage spriteSheet;

    public myView(World w, int width, int height) {
        super(w, width, height);
        try {
            spriteSheet = ImageIO.read(new File("data/charSprites.png")); //loading sprite sheet
            animation = new Animation(spriteSheet); //providing the animation class with the sprite sheeet
        } catch (IOException e) {
            e.printStackTrace();
        }
       // background = new ImageIcon("data/university.gif").getImage();
    }


    public MovableCharacter getCharacter() {
        return character;
    }

    public void setCharacter(MovableCharacter character) {
        this.character = character;
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        BufferedImage initChar = animation.grabImage(65,130, 50,75);
        g.drawImage(initChar, 10, 15,60,60,null);

    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);

    }
}
