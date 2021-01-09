package dataStructure.screens;

import dataStructure.*;
import dataStructure.controls.KeyInput;
import dataStructure.controls.PaddleController;
import dataStructure.objects.Item;
import dataStructure.objects.Text;

import java.awt.*;


public class GameScreen extends ScreenManager {
    private final KeyInput keyInput = new KeyInput();
    private final dataStructure.objects.Item playerOne;
    private final dataStructure.objects.Item playerTwo;
    private final dataStructure.objects.Item itemToHit;
    private final GameRules gameRules;
    private final PaddleController paddleController;
    private final Text playerOneScoreText;
    private final Text playerTwoScoreText;


    public GameScreen() {
        this.addKeyListener(getKeyInput());
        Constants.INSETS_TOP    = this.getInsets().top;
        Constants.INSETS_BOTTOM = this.getInsets().bottom;

        playerOneScoreText = new Text(0, Constants.SCORE_X_POS, Constants.SCORE_Y_POS);
        playerTwoScoreText = new Text(0, getPlayerTwoScoreXPos(), Constants.SCORE_Y_POS);

        playerOne   = new dataStructure.objects.Rectangle(Constants.PADDLE_PADDING, getPaddleYCoordinateCentered(),
                Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerTwo   = new dataStructure.objects.Rectangle(getPlayerTwoXCoordinateCentered(),
                getPaddleYCoordinateCentered(), Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        itemToHit = new dataStructure.objects.Ball(Constants.SCREEN_WIDTH / 2.0, Constants.SCREEN_HEIGHT / 2.0,
                                    Constants.BALL_RADIUS, Constants.BALL_RADIUS, Constants.PADDLE_COLOR);

        paddleController    = new PaddleController(getPlayerOne(), getPlayerTwo(), getKeyInput());
        gameRules           = new GameRules(getItemToHit(), getPlayerOne(), getPlayerTwo(), getPlayerOneScoreText(),
                                            getPlayerTwoScoreText());
    }

    private double getPlayerTwoXCoordinateCentered() {
        return Constants.SCREEN_WIDTH - Constants.PADDLE_PADDING - Constants.PADDLE_WIDTH;
    }

    public double getPaddleYCoordinateCentered() {
        return (Constants.SCREEN_HEIGHT - Constants.PADDLE_HEIGHT) / 2;
    }

    private int getPlayerTwoScoreXPos() {
        return Constants.SCREEN_WIDTH - Constants.SCORE_X_POS - Constants.SCORE_SIZE;
    }

    @Override
    void update() {
        getPaddleController().update();
        getGameRules().update();
    }

    @Override
    void draw(Graphics2D graphics2D) {
        getPlayerOne().draw(graphics2D);
        getPlayerTwo().draw(graphics2D);
        getItemToHit().draw(graphics2D);

        getPlayerOneScoreText().draw(graphics2D);
        getPlayerTwoScoreText().draw(graphics2D);
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }

    public dataStructure.objects.Item getPlayerOne() {
        return playerOne;
    }

    public dataStructure.objects.Item getPlayerTwo() {
        return playerTwo;
    }

    public Item getItemToHit() {
        return itemToHit;
    }

    public GameRules getGameRules() {
        return gameRules;
    }

    public PaddleController getPaddleController() {
        return paddleController;
    }

    public Text getPlayerOneScoreText() {
        return playerOneScoreText;
    }

    public Text getPlayerTwoScoreText() {
        return playerTwoScoreText;
    }

}
