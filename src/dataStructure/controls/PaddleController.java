package dataStructure.controls;

import dataStructure.objects.Item;

import java.awt.event.KeyEvent;

public class PaddleController {
    private final Item playerOne;
    private final Item playerTwo;
    private final KeyInput keyInput;
    Command moveFirstPaddleUp;
    Command moveFirstPaddleDown;
    Command moveSecondPaddleUp;
    Command moveSecondPaddleDown;
    
    public PaddleController(Item playerOne, Item playerTwo, KeyInput keyInput) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.keyInput = keyInput;
    }

    public void update() {
        moveFirstPaddleUp = new MovePaddleUp(getKeyInput(), KeyEvent.VK_W, getPlayerOne());
        moveFirstPaddleUp.execute();
        moveFirstPaddleDown = new MovePaddleDown(getKeyInput(), KeyEvent.VK_S, getPlayerOne());
        moveFirstPaddleDown.execute();

        moveSecondPaddleUp = new MovePaddleUp(keyInput, KeyEvent.VK_UP, getPlayerTwo());
        moveSecondPaddleUp.execute();
        moveSecondPaddleDown = new MovePaddleDown(getKeyInput(), KeyEvent.VK_DOWN, getPlayerTwo());
        moveSecondPaddleDown.execute();
    }

    public Item getPlayerOne() {
        return playerOne;
    }

    public Item getPlayerTwo() {
        return playerTwo;
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }
}
