package dataStructure;

public class Ball {
    public Rectangle rectangle;
    public Rectangle leftPaddle;
    public Rectangle rightPaddle;
    public Text playerOneScoreText;
    public Text playerTwoScoreText;
    private double velocityX;
    private double velocityY;

    public Ball(Rectangle rectangle, Rectangle leftPaddle, Rectangle rightPaddle, Text playerOneScoreText, Text playerTwoScoreText) {
        this.rectangle = rectangle;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.playerOneScoreText = playerOneScoreText;
        this.playerTwoScoreText = playerTwoScoreText;
        this.velocityX = Constants.VELOCITY_X;
        this.velocityY = Constants.VELOCITY_Y;
    }

    public double calculateNewVelocityAngle(Rectangle paddle) {
        double relativeIntersectY = (paddle.y + (paddle.height / 2.0)) - (this.rectangle.y + (this.rectangle.height / 2.0));
        double normalIntersectY = relativeIntersectY / (paddle.height / 2.0);
        double theta = normalIntersectY * Constants.MAX_ANGLE;
        return Math.toRadians(theta);
    }

    public void update(double deltaTime) {
        if (velocityY >= 0) {
            if (this.rectangle.y + this.rectangle.height > Constants.SCREEN_HEIGHT) {
                this.velocityY *= -1;
            }
        } else if (velocityY < 0) {
            if (this.rectangle.y < Constants.INSETS_TOP) {
                this.velocityY *= -1;
            }

        }
        if (velocityX < 0) {
            if (this.rectangle.x <= this.leftPaddle.x + this.leftPaddle.width && this.rectangle.x + this.rectangle.width >= this.leftPaddle.x &&
                    this.rectangle.y >= this.leftPaddle.y && this.rectangle.y <= this.leftPaddle.y + this.leftPaddle.height) {

                double theta = calculateNewVelocityAngle(leftPaddle);
                double newVelocityX = Math.abs((Math.cos(theta)) * Constants.BALL_SPEED);
                double newVelocityY = (-Math.sin(theta)) * Constants.BALL_SPEED;

                double oldSign = Math.signum(velocityX);
                this.velocityX = newVelocityX * (-1.0 * oldSign);
                this.velocityY = newVelocityY;

            }
        } else if (velocityX >= 0) {
            if (this.rectangle.x + this.rectangle.width >= this.rightPaddle.x && this.rectangle.x <= this.rightPaddle.x + this.rightPaddle.width &&
                    this.rectangle.y >= this.rightPaddle.y && this.rectangle.y <= this.rightPaddle.y + this.rightPaddle.height) {

                double theta = calculateNewVelocityAngle(rightPaddle);
                double newVelocityX = Math.abs((Math.cos(theta)) * Constants.BALL_SPEED);
                double newVelocityY = (-Math.sin(theta)) * Constants.BALL_SPEED;

                double oldSign = Math.signum(velocityX);
                this.velocityX = newVelocityX * (-1.0 * oldSign);
                this.velocityY = newVelocityY;
            }
        }
        if (deltaTime > 2) deltaTime = 0.0035; // temporary fixing score after restart
        this.rectangle.x += velocityX * deltaTime;
        this.rectangle.y += velocityY * deltaTime;


        if (this.rectangle.x + this.rectangle.width < leftPaddle.x) {

            int rightScore = Integer.parseInt(playerTwoScoreText.score);
            rightScore++;
            playerTwoScoreText.score = "" + rightScore;
            this.rectangle.x = Constants.SCREEN_WIDTH / 2.0;
            this.rectangle.y = Constants.SCREEN_HEIGHT / 2.0;
            this.velocityX = Constants.VELOCITY_X;
            this.velocityY = Constants.VELOCITY_Y;

            if (rightScore >= Constants.WIN_SCORE) {
                Main.changeWindow(2);
            }

        } else if (this.rectangle.x > rightPaddle.x + rightPaddle.width) {
            int leftScore = Integer.parseInt(playerOneScoreText.score);
            leftScore++;
            playerOneScoreText.score = "" + leftScore;
            this.rectangle.x = Constants.SCREEN_WIDTH / 2.0;
            this.rectangle.y = Constants.SCREEN_HEIGHT / 2.0;
            this.velocityX = -Constants.VELOCITY_X;
            this.velocityY = Constants.VELOCITY_Y;

            if (leftScore >= Constants.WIN_SCORE) {
                Main.changeWindow(2);
            }
        }
    }
}
