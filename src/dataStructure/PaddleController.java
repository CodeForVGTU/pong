package dataStructure;

import java.awt.event.KeyEvent;

public class PaddleController {
    public Rectangle playerOne;
    public Rectangle playerTwo;
    public KeyInput keyInput;

    public PaddleController(Rectangle playerOne, Rectangle playerTwo, KeyInput keyInput) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.keyInput = keyInput;
    }

    public void update(double deltaTime) {
        if (keyInput.isKeyPressed(KeyEvent.VK_W)) {
            if(playerOne.y - Constants.PADDLE_SPEED * deltaTime > Constants.INSETS_TOP) {
                this.playerOne.y -= Constants.PADDLE_SPEED * deltaTime;
            }
        }
        else if (keyInput.isKeyPressed(KeyEvent.VK_S)) {
            if((playerOne.y + Constants.PADDLE_SPEED * deltaTime) + playerOne.height < Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
                this.playerOne.y += Constants.PADDLE_SPEED * deltaTime;
            }
        }
        if (keyInput.isKeyPressed(KeyEvent.VK_UP)) {
            if(playerTwo.y - Constants.PADDLE_SPEED * deltaTime > Constants.INSETS_TOP) {
                this.playerTwo.y -= Constants.PADDLE_SPEED * deltaTime;
            }
        }
        else if (keyInput.isKeyPressed(KeyEvent.VK_DOWN)) {
            if((playerTwo.y + Constants.PADDLE_SPEED * deltaTime) + playerTwo.height < Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
                this.playerTwo.y += Constants.PADDLE_SPEED * deltaTime;
            }
        }
    }
}
