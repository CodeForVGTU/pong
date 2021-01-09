package dataStructure;

public class Time {
    public static double timeStarted = System.nanoTime();

    /**
     * @return converting nanoseconds to seconds multiplying by 1E-9
     */
    public static double getTime() {

        return (System.nanoTime() - timeStarted) * 1E-9;
    }
}
