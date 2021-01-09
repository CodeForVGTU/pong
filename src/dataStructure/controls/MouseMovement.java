package dataStructure.controls;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMovement extends MouseAdapter implements MouseMotionListener {
    private boolean isPressed = false;
    private double x = 0.0;
    private double y = 0.0;

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        setPressed(true);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        setPressed(false);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        setX(mouseEvent.getX());
        setY(mouseEvent.getY());
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
