package dataStructure;

import javax.swing.*;
import java.awt.*;


public class GameOverScreen extends JFrame implements Runnable {

    public Graphics2D graphics2D;
    public KeyInput keyInput = new KeyInput();
    public MouseMovement mouseMovement = new MouseMovement();
    public Text restart;
    public boolean isRunning = true;


    public GameOverScreen() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyInput);
        this.addMouseListener(mouseMovement);
        this.addMouseMotionListener(mouseMovement);
        this.restart = new Text("Restart?", Constants.SCREEN_WIDTH / 2.0 - Constants.FONT_SIZE * "Restart?".length() / 2.0, Constants.SCREEN_HEIGHT / 2.0);
        graphics2D = (Graphics2D) getGraphics();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    public void update() {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferGraphics = doubleBufferImage.getGraphics();
        this.draw(doubleBufferGraphics);
        graphics2D.drawImage(doubleBufferImage, 0, 0, this);

        if (mouseMovement.getX() > restart.x && mouseMovement.getX() < restart.x + restart.textWidth &&
                mouseMovement.getY() > restart.y - restart.textHeight && mouseMovement.getY() < restart.y + restart.textHeight / 4.0) {
            restart.color = new Color(203, 31, 31);
            if (mouseMovement.isPressed()) {

                Main.changeWindow(3);
            }
        } else {
            restart.color = Color.WHITE;
        }

    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        restart.draw(graphics2D);
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
