package dataStructure.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private final boolean[] keyPressed = new boolean[128];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        getKeyPressed()[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        getKeyPressed()[e.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int keyCode) {
        return getKeyPressed()[keyCode];
    }

    public boolean[] getKeyPressed() {
        return keyPressed;
    }
}
