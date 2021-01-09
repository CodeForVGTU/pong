package dataStructure.objects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Item{

    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, width, height, color);
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
        graphics2D.fill(new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight()));
    }

}
