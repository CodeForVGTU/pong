package dataStructure.controls;

import dataStructure.Constants;
import dataStructure.objects.Item;


public class MovePaddleDown implements Command {
    private final KeyInput keyInput;
    private final Item playerOne;
    private final int virtualKeyDown;

    public MovePaddleDown(KeyInput keyInput, int virtualKeyDown, Item playerOne) {
        this.keyInput = keyInput;
        this.virtualKeyDown = virtualKeyDown;
        this.playerOne = playerOne;
    }

    @Override
    public void execute() {
        if (getKeyInput().isKeyPressed(virtualKeyDown) && hasNotReachedBottom(getPlayerOne()))
            getPlayerOne().increaseCoordinateY(Constants.PADDLE_SPEED * Constants.DELTA_TIME);
    }

    private boolean hasNotReachedBottom(Item player) {
        return (player.getY() + Constants.PADDLE_SPEED * Constants.DELTA_TIME) +
                player.getHeight() < Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM;
    }

    public Item getPlayerOne() {
        return playerOne;
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }
}
