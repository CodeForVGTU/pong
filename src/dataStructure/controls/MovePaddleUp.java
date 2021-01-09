package dataStructure.controls;

import dataStructure.Constants;
import dataStructure.objects.Item;

public class MovePaddleUp implements Command {
    private final KeyInput keyInput;
    private final Item playerOne;
    private final int virtualKeyUp;

    public MovePaddleUp(KeyInput keyInput, int virtualKeyUp, Item playerOne) {
        this.keyInput = keyInput;
        this.virtualKeyUp = virtualKeyUp;
        this.playerOne = playerOne;
    }

    @Override
    public void execute() {
        if (getKeyInput().isKeyPressed(virtualKeyUp) && hasNotReachedTop(getPlayerOne()))
            getPlayerOne().decreaseCoordinateY(Constants.PADDLE_SPEED * Constants.DELTA_TIME);
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }

    public Item getPlayerOne() {
        return playerOne;
    }

    private boolean hasNotReachedTop(Item player) {
        return player.getY() - Constants.PADDLE_SPEED * Constants.DELTA_TIME > Constants.INSETS_TOP;
    }
}
