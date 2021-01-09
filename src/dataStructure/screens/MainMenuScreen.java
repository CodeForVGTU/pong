package dataStructure.screens;

import dataStructure.Constants;
import dataStructure.objects.Text;

import java.awt.*;


public class MainMenuScreen extends ScreenManager {
    private final Text startGame;
    private final Text exitGame;
    private final Text pongText;

    public MainMenuScreen() {
        super();
        this.pongText = initializeButton("PONG", 200.0);
        this.startGame = initializeButton("Start", Constants.SCREEN_HEIGHT / 2.0);
        this.exitGame = initializeButton("Exit", Constants.SCREEN_HEIGHT / 2.0 + 70);
    }

    @Override
    public void update() {
        getButton(getStartGame(), 1);
        getButton(getExitGame(), 4);
    }

    @Override
    void draw(Graphics2D graphics2D) {
        getStartGame().draw(graphics2D);
        getExitGame().draw(graphics2D);
        getPongText().draw(graphics2D);
    }

    public Text getStartGame() {
        return startGame;
    }

    public Text getExitGame() {
        return exitGame;
    }

    public Text getPongText() {
        return pongText;
    }
}
