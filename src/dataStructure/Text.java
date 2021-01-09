package dataStructure;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Text {
    public String score;
    public Font font;
    public double x, y;
    public double textWidth;
    public double textHeight;
    public Color color = Color.WHITE;


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
        graphics2D.setColor(color);
        graphics2D.setFont(font);
        graphics2D.drawString(score, (float) x, (float) y);
    }
}
