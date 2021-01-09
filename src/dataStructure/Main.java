package dataStructure;

public class Main {
    public static int STATE = 0;
    public static Thread MAIN_THREAD;
    public static MainMenu MAIN_MENU;
    public static GameWindow GAME_WINDOW;
    public static GameOverScreen GAME_OVER_SCREEN;

    public static void main(String[] args) {
        MAIN_MENU = new MainMenu();
        MAIN_THREAD = new Thread(MAIN_MENU);
        MAIN_THREAD.start();
    }

    public static void changeWindow(int newSTATE) {
        if (newSTATE == 1 && STATE == 0) {
            MAIN_MENU.stop();
            GAME_WINDOW = new GameWindow();
            MAIN_THREAD = new Thread(GAME_WINDOW);
            MAIN_THREAD.start();

        } else if (newSTATE == 2) {
            GAME_WINDOW.stop();

            GAME_OVER_SCREEN = new GameOverScreen();
            MAIN_THREAD = new Thread(GAME_OVER_SCREEN);
            MAIN_THREAD.start();

        } else if (newSTATE == 3) {
            GAME_OVER_SCREEN.stop();

            GAME_WINDOW = new GameWindow();
            MAIN_THREAD = new Thread(GAME_WINDOW);
            MAIN_THREAD.start();

        }
        STATE = newSTATE;
    }
}
