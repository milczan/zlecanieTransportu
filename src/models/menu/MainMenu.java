package models.menu;

import java.util.Arrays;

/**
 * Main menu class
 */
public class MainMenu extends Menu {
    /**
     * Print main menu available options, defined in MainMenuItems enum
     */
    @Override
    public void printMenu() {
        Arrays.asList(MainMenuItems.values()).forEach(item ->
                System.out.printf("%-5s- %s\n", item.getMenuItemName(), item.getMenuItemDescription()));
    }
}
