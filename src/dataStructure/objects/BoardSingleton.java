package dataStructure.objects;


import dataStructure.Constants;

import javax.swing.*;
import java.awt.*;

public class BoardSingleton extends JFrame{
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private static final BoardSingleton instance = new BoardSingleton();

    private BoardSingleton() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }
    public static BoardSingleton getInstance(){
        return instance;
    }

    final public int getScreenCenteredY() {
        return getDim().height / 2 - this.getSize().height / 2;
    }

    final public int getScreenCenteredX() {
        return getDim().width / 2 - this.getSize().width / 2;
    }

    public Dimension getDim() {
        return dim;
    }
}
