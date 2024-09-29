package gowe.utils;

public class SleepUtil {

    /**
     * Sleeps for 10 seconds.
     */
    public static void sleepFor10Seconds() {
        sleep(10000);
    }

    /**
     * Sleeps for 15 seconds.
     */
    public static void sleepFor15Seconds() {
        sleep(15000);
    }

    /**
     * Sleeps for 20 seconds.
     */
    public static void sleepFor20Seconds() {
        sleep(20000);
    }

    /**
     * Sleeps for 25 seconds.
     */
    public static void sleepFor25Seconds() {
        sleep(25000);
    }

    /**
     * Sleeps for 30 seconds.
     */
    public static void sleepFor30Seconds() {
        sleep(30000);
    }

    /**
     * Private method to handle the sleep functionality.
     *
     * @param milliseconds The duration to sleep in milliseconds.
     */
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
