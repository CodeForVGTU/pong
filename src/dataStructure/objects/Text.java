package dataStructure.objects;

import dataStructure.Constants;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Text {
    private String score;
    private Font font;
    private final double x;
    private final double y;
    private double textWidth;
    private double textHeight;
    private Color color = Color.WHITE;

    public Text(String score, double x, double y) {
        this.score = score;
        this.x = x;
        this.y = y;
        getCustomFont(Constants.FONT_SIZE);
        this.textWidth = font.getSize() * score.length();
        this.textHeight = font.getSize();
    }

    public Text(int score, double x, double y) {
        getCustomFont(Constants.SCORE_SIZE);
        this.score = "" + score;
        this.x = x;
        this.y = y;
    }

    private void getCustomFont(double fontSize) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(Constants.FONT_PATH)).deriveFont((float) fontSize);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(getColor());
        graphics2D.setFont(getFont());
        graphics2D.drawString(getScore(), (float) getX(), (float) getY());
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Font getFont() {
        return font;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTextWidth() {
        return textWidth;
    }

    public double getTextHeight() {
        return textHeight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
