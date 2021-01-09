package dataStructure;

import javax.swing.*;
import java.awt.*;


public class MainMenu extends JFrame implements Runnable {

    public Graphics2D graphics2D;
    public KeyInput keyInput = new KeyInput();
    public MouseMovement mouseMovement = new MouseMovement();
    public Text startGame;
    public Text exitGame;
    public Text pongText;
    public boolean isRunning = true;


    public MainMenu() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyInput);
        this.addMouseListener(mouseMovement);
        this.addMouseMotionListener(mouseMovement);
        this.pongText = new Text("PONG", Constants.SCREEN_WIDTH / 2.0 - Constants.FONT_SIZE * "PONG".length() / 2.0, 200.0);
        this.startGame = new Text("Start", Constants.SCREEN_WIDTH / 2.0 - Constants.FONT_SIZE * "Start".length() / 2.0, Constants.SCREEN_HEIGHT / 2.0);
        this.exitGame = new Text("Exit",  Constants.SCREEN_WIDTH / 2.0 - Constants.FONT_SIZE * "Exit".length() / 2.0, Constants.SCREEN_HEIGHT / 2.0 + 70);
        graphics2D = (Graphics2D) getGraphics();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    public void update() {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferGraphics = doubleBufferImage.getGraphics();
        this.draw(doubleBufferGraphics);
        graphics2D.drawImage(doubleBufferImage, 0, 0, this);

        if (mouseMovement.getX() > startGame.x && mouseMovement.getX() < startGame.x + startGame.textWidth &&
                mouseMovement.getY() > startGame.y - startGame.textHeight && mouseMovement.getY() < startGame.y + startGame.textHeight / 4.0) {
            startGame.color = new Color(203, 31, 31);
            if (mouseMovement.isPressed()) {

                Main.changeWindow(1);
            }
        } else {
            startGame.color = Color.WHITE;
        }

        if (mouseMovement.getX() > exitGame.x && mouseMovement.getX() < exitGame.x + exitGame.textWidth &&
                mouseMovement.getY() > exitGame.y - exitGame.textHeight && mouseMovement.getY() < exitGame.y + exitGame.textHeight / 4.0) {
            exitGame.color = new Color(203, 31, 31);
            if (mouseMovement.isPressed()) {
                System.exit(0);
            }
        } else {
            exitGame.color = Color.WHITE;
        }
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        startGame.draw(graphics2D);
        exitGame.draw(graphics2D);
        pongText.draw(graphics2D);
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            update();

        }
        this.dispose(); // makes window disappear

    }
}
