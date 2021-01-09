package dataStructure.screens;

import dataStructure.Constants;
import dataStructure.Main;
import dataStructure.controls.MouseMovement;
import dataStructure.objects.BoardSingleton;
import dataStructure.objects.Text;

import javax.swing.*;
import java.awt.*;

abstract class ScreenManager extends JFrame implements Runnable {
    private Graphics2D graphics2D;
    private final MouseMovement mouseMovement = new MouseMovement();
    private boolean isRunning = true;
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    BoardSingleton board = BoardSingleton.getInstance();

    public ScreenManager() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.WINDOW_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(getMouseMovement());
        this.addMouseMotionListener(getMouseMovement());
        this.setLocation(board.getScreenCenteredX(), board.getScreenCenteredY());
        setGraphics2D((Graphics2D) getGraphics());
    }

    final void updateWindow() {
        Image doubleBufferImage = createImage(getWidth(), getHeight());
        Graphics doubleBufferGraphics = doubleBufferImage.getGraphics();
        this.drawToWindow(doubleBufferGraphics);
        getGraphics2D().drawImage(doubleBufferImage, 0, 0, this);

        update();
    }

    final void drawToWindow(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        draw(graphics2D);
    }

    final void getButton(Text buttonText, int screenNumber) {
        if (isMouseOverButton(buttonText)) {
            buttonText.setColor(new Color(203, 31, 31));
            if (getMouseMovement().isPressed()) {
                Main.changeWindow(screenNumber);
            }
        } else {
            buttonText.setColor(Color.WHITE);
        }
    }

    private boolean isMouseOverButton(Text buttonText) {
        return getMouseMovement().getX() > buttonText.getX() && getMouseMovement().getX() <
                buttonText.getX() + buttonText.getTextWidth() && getMouseMovement().getY() >
                buttonText.getY() - buttonText.getTextHeight() && getMouseMovement().getY() < buttonText.getY() +
                buttonText.getTextHeight() / 4.0;
    }

    final Text initializeButton(String string, double yCoordinate) {
        return new Text(string, Constants.SCREEN_WIDTH / 2.0 - Constants.FONT_SIZE * string.length() / 2.0,
                yCoordinate);
    }

    final public void stop() {
        setRunning(false);
    }

    @Override
    public void run() {
        while (isRunning()) {
            updateWindow();
        }
        this.dispose();
    }

    abstract void update();
    abstract void draw(Graphics2D graphics2D);

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }

    public void setGraphics2D(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public MouseMovement getMouseMovement() {
        return mouseMovement;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Dimension getDim() {
        return dim;
    }
}
