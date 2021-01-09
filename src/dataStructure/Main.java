package dataStructure;

import dataStructure.screens.GameOverScreen;
import dataStructure.screens.GameScreen;
import dataStructure.screens.MainMenuScreen;

public class Main {
    private static int STATE = 0;
    private static Thread MAIN_THREAD;
    private static MainMenuScreen MAIN_MENU;
    private static GameScreen GAME_WINDOW;
    private static GameOverScreen GAME_OVER_SCREEN;

    public static void main(String[] args) {
        MAIN_MENU = new MainMenuScreen();
        MAIN_THREAD = new Thread(MAIN_MENU);
        MAIN_THREAD.start();
    }

    public static void changeWindow(int newSTATE) {
        switch (newSTATE) {
            case 1:
                if (STATE == 0) {
                    MAIN_MENU.stop();
                    startGameScreenThread();
                }
                break;
            case 2:
                GAME_WINDOW.stop();
                startGameOverScreenThread();
                break;
            case 3:
                GAME_OVER_SCREEN.stop();
                startGameScreenThread();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Wrong screen ID.");
        }
        STATE = newSTATE;
    }

    private static void startGameOverScreenThread() {
        GAME_OVER_SCREEN = new GameOverScreen();
        MAIN_THREAD = new Thread(GAME_OVER_SCREEN);
        MAIN_THREAD.start();
    }

    private static void startGameScreenThread() {
        GAME_WINDOW = new GameScreen();
        MAIN_THREAD = new Thread(GAME_WINDOW);
        MAIN_THREAD.start();
    }
}
