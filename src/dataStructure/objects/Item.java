package dataStructure.objects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Item {
    private double y;
    private double x;
    private final double width;
    private final double height;
    private final Color color;

    public Item(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void increaseCoordinateX(double number) {
        this.x += number;
    }

    public void increaseCoordinateY(double number) {
        this.y += number;
    }

    public void decreaseCoordinateY(double number) {
        this.y -= number;
    }
}
