package unitTest;

import dataStructure.Constants;
import dataStructure.GameRules;
import dataStructure.objects.Ball;
import dataStructure.objects.Item;
import dataStructure.objects.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    @Test
    void shouldPlayerFirstScore() {
        // Arrange
        Item ball = new Ball(0, 0, 0, 0, Constants.PADDLE_COLOR);
        Item playerSecond = new Rectangle(0, 0, 0, 0, Constants.PADDLE_COLOR);

        // Act
        ball.setX(100);
        playerSecond.setX(99);
        GameRules gameRules = new GameRules(ball, null, playerSecond, null, null);

        // Assert
        assertTrue(gameRules.hasPlayerOneScoredAPoint());
    }

    @Test
    void shouldHitBottomLedge() {
        // Arrange
        Item ball = new Rectangle(0, 0, 0, 400, Constants.PADDLE_COLOR);
        Item rightPaddle = new Rectangle(0, 0, 0, 0, Constants.PADDLE_COLOR);

        // Act
        ball.setY(201);
        GameRules gameRules = new GameRules(ball, null, rightPaddle, null, null);

        // Assert
        assertTrue(gameRules.hasHitBottomLedge());
    }

}