package dataStructure;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame implements Runnable {

    public Graphics2D graphics2D;
    public KeyInput keyInput = new KeyInput();
    public Rectangle playerOne;
    public Rectangle playerTwo;
    public Rectangle ballRect;
    public Ball ball;
    public PaddleController paddleController;
    public Text playerOneScoreText;
    public Text playerTwoScoreText;
    public boolean isRunning = true;


    public GameWindow() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyInput);
        Constants.INSETS_TOP = this.getInsets().top;
        Constants.INSETS_BOTTOM = this.getInsets().bottom;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        playerOneScoreText = new Text(0, Constants.SCORE_X_POS, Constants.SCORE_Y_POS);
        playerTwoScoreText = new Text(0, Constants.SCREEN_WIDTH - Constants.SCORE_X_POS - Constants.SCORE_SIZE, Constants.SCORE_Y_POS);

        graphics2D = (Graphics2D) this.getGraphics();

        playerOne = new Rectangle(Constants.PADDLE_PADDING, (Constants.SCREEN_HEIGHT - Constants.PADDLE_HEIGHT) / 2, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerTwo = new Rectangle(Constants.SCREEN_WIDTH - Constants.PADDLE_PADDING - Constants.PADDLE_WIDTH, (Constants.SCREEN_HEIGHT - Constants.PADDLE_HEIGHT) / 2, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);

        paddleController = new PaddleController(playerOne, playerTwo, keyInput);
        ballRect = new Rectangle((double) Constants.SCREEN_WIDTH / 2, (double) Constants.SCREEN_HEIGHT / 2, Constants.BALL_RADIUS, Constants.BALL_RADIUS, Constants.PADDLE_COLOR);
        ball = new Ball(ballRect, playerOne, playerTwo, playerOneScoreText, playerTwoScoreText);
    }

    public void update(double deltaTime) {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferGraphics = doubleBufferImage.getGraphics();
        this.draw(doubleBufferGraphics);
        graphics2D.drawImage(doubleBufferImage, 0, 0, this);


        paddleController.update(deltaTime);
        ball.update(deltaTime);
        System.out.println(1/deltaTime + " fps");
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);



        playerOne.draw(graphics2D);
        playerTwo.draw(graphics2D);
        ballRect.draw(graphics2D);

        playerOneScoreText.draw(graphics2D);
        playerTwoScoreText.draw(graphics2D);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        while (isRunning) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            //double deltaTime = 0.015;
            lastFrameTime = time;
            update(deltaTime);
        }
        this.dispose();
    }

    public void stop() {
        isRunning = false;
    }
}
