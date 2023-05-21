package models.menu;

/**
 * Help class
 */
public class Help {
    /**
     * Print application options for selected menu
     */
    public static void printHelp(Menu menu) {
        clearScreen();
        menu.printMenu();
    }

    /**
     * Clear the console by sending ANSI escape codes.
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
