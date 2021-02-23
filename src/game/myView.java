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


    private Animation animation;
    //BufferedImage spriteSheet;

    public myView(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/BGI.gif").getImage();

    }

    @Override
    protected void paintForeground(Graphics2D g) {

    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);

    }
}
