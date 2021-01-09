package dataStructure.screens;

import dataStructure.Constants;
import dataStructure.objects.Text;

import java.awt.*;


public class GameOverScreen extends ScreenManager {
    private final Text restart;

    public GameOverScreen() {
        super();
        this.restart = initializeButton("restart?", Constants.SCREEN_HEIGHT / 2.0);
    }

    @Override
    public void update() {
        getButton(getRestart(), 3);
    }

    @Override
    void draw(Graphics2D graphics2D) {
        getRestart().draw(graphics2D);
    }

    public Text getRestart() {
        return restart;
    }
}
