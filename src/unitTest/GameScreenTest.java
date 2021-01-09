package unitTest;

import dataStructure.screens.GameScreen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameScreenTest {

    @Test
    void shouldGetPaddleYCoordinateCenteredByConstants () {
        GameScreen gameScreen = new GameScreen();

        gameScreen.getPaddleYCoordinateCentered();

        assertNotEquals(gameScreen.getPaddleYCoordinateCentered(), 285);
    }

}