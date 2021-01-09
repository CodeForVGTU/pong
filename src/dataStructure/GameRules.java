package dataStructure;

import dataStructure.objects.Item;
import dataStructure.objects.Rectangle;
import dataStructure.objects.Text;

public class GameRules {
    private final Item ball;
    private final Item leftPaddle;
    private final Item rightPaddle;
    private final Text playerOneScoreText;
    private final Text playerTwoScoreText;
    private double velocityX;
    private double velocityY;

    public GameRules(Item ball, Item leftPaddle, Item rightPaddle, Text playerOneScoreText,
                     Text playerTwoScoreText) {
        this.ball = ball;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.playerOneScoreText = playerOneScoreText;
        this.playerTwoScoreText = playerTwoScoreText;
        this.velocityX = Constants.VELOCITY_X;
        this.velocityY = Constants.VELOCITY_Y;
    }

    private double calculateNewVelocityAngle(Item paddle) {
        double relativeIntersectY = (paddle.getY() + (paddle.getHeight() / Constants.VALUE_OF_TWO)) - (getBall().getY() +
                (getBall().getHeight() / Constants.VALUE_OF_TWO));
        double normalIntersectY = relativeIntersectY / (paddle.getHeight() / Constants.VALUE_OF_TWO);
        double theta = normalIntersectY * Constants.MAX_ANGLE;
        return Math.toRadians(theta);
    }

    public void update() {
        reverseBallYVelocity();
        calculateBallCoordinates();
        checkScore();
    }

    private void calculateBallCoordinates() {
        if (getVelocityX() < 0 && hasBallHitLeftPaddle()) calculateVelocity(getLeftPaddle());
        else if (getVelocityX() >= 0 && hasBallHitRightPaddle()) calculateVelocity(getRightPaddle());

        getBall().increaseCoordinateX(getVelocityX() * Constants.DELTA_TIME);
        getBall().increaseCoordinateY(getVelocityY() * Constants.DELTA_TIME);
    }

    private boolean hasBallHitRightPaddle() {
        return getBall().getX() + getBall().getWidth() >= getRightPaddle().getX() && getBall().getX()
                <= getRightPaddle().getX() + getRightPaddle().getWidth() && getBall().getY() >= getRightPaddle().getY()
                && getBall().getY() <= getRightPaddle().getY() + getRightPaddle().getHeight();
    }

    private boolean hasBallHitLeftPaddle() {
        return getBall().getX() <= getLeftPaddle().getX() + getLeftPaddle().getWidth() && getBall().getX() +
                getBall().getWidth() >= getLeftPaddle().getX() && getBall().getY() >= getLeftPaddle().getY() &&
                getBall().getY() <= getLeftPaddle().getY() + getLeftPaddle().getHeight();
    }

    private void calculateVelocity(Item leftPaddle) {
        double theta = calculateNewVelocityAngle(leftPaddle);
        double newVelocityX = Math.abs((Math.cos(theta)) * Constants.BALL_SPEED);
        double newVelocityY = (-Math.sin(theta)) * Constants.BALL_SPEED;

        double oldSign = Math.signum(getVelocityX());
        setVelocityX(newVelocityX * (-1.0 * oldSign));
        setVelocityY(newVelocityY);
    }

    private void reverseBallYVelocity() {
        if ((getVelocityY() >= 0 && hasHitBottomLedge()) || (getVelocityY() < 0 && hasHitTopLedge()))
            setVelocityYReversed();
    }

    private boolean hasHitTopLedge() {
        return getBall().getY() < Constants.INSETS_TOP;
    }

    public boolean hasHitBottomLedge() {
        return getBall().getY() + getBall().getHeight() > Constants.SCREEN_HEIGHT;
    }

    private void checkScore() {
        if (hasPlayerTwoScoredAPoint()) {
            int rightScore = updateScore(getPlayerTwoScoreText());
            changeWindowIfWon(rightScore);
        }
        if (hasPlayerOneScoredAPoint()) {
            int leftScore = updateScore(getPlayerOneScoreText());
            changeWindowIfWon(leftScore);
        }

        resetBallIfScored();
    }

    private void changeWindowIfWon(int rightScore) {
        if (rightScore >= Constants.WIN_SCORE) Main.changeWindow(2);
    }

    private void resetBallIfScored() {
        if (hasPlayerOneScoredAPoint() || hasPlayerTwoScoredAPoint()) {
            resetBall();
        }
    }

    private int updateScore(Text playerScoreText) {
        int rightScore = Integer.parseInt(playerScoreText.getScore());
        rightScore++;
        playerScoreText.setScore("" + rightScore);
        return rightScore;
    }

    private void resetBall() {
        getBall().setX(Constants.SCREEN_WIDTH / Constants.VALUE_OF_TWO);
        getBall().setY(Constants.SCREEN_HEIGHT / Constants.VALUE_OF_TWO);
        setVelocityX(Constants.VELOCITY_X);
        setVelocityY(Constants.VELOCITY_Y);
    }

    public boolean hasPlayerOneScoredAPoint() {
        return getBall().getX() > getRightPaddle().getX() + getRightPaddle().getWidth();
    }

    private boolean hasPlayerTwoScoredAPoint() {
        return getBall().getX() + getBall().getWidth() < getLeftPaddle().getX();
    }

    public Item getBall() {
        return ball;
    }

    public Item getLeftPaddle() {
        return leftPaddle;
    }

    public Item getRightPaddle() {
        return rightPaddle;
    }

    public Text getPlayerOneScoreText() {
        return playerOneScoreText;
    }

    public Text getPlayerTwoScoreText() {
        return playerTwoScoreText;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocityYReversed() {
        this.velocityY *= -1;
    }
}
