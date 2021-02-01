package game;

import city.cs.engine.WorldView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

    private MyView view;

    public KeyHandler (MyView view) {
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        System.out.println("getkey|Char()" + e.getKeyChar());
        switch (e.getKeyChar()) {
            case 'w':
                view.getCharacter().jump(2.0f);
                break;

            case 'a':
                System.out.println("hello for a");
                view.getCharacter().startWalking(-2.0f);
                break;

            case 'd':
                view.getCharacter().startWalking(2.0f);
                break;

            default:
                System.out.println("wrong Key");
                break;
        }

        super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar());
        super.keyReleased(e);
    }
}
