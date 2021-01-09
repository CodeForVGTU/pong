package dataStructure;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMovement extends MouseAdapter implements MouseMotionListener {
    public boolean isPressed = false;
    public double x = 0.0;
    public double y = 0.0;

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        isPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        isPressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        this.x = mouseEvent.getX();
        this.y = mouseEvent.getY();
    }

    public boolean isPressed() {
        return isPressed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
