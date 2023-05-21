package models.menu;

import interfaces.MenuItemInterface;

/**
 * Main menu items enum
 */
public enum MainMenuItems implements MenuItemInterface {
    /**
     * Available main menu options
     */
    EXIT        ("0", "Zakończ program."),

    ADD_ITEM    ("1", "Dodaj przesyłkę do zlecenia."),

    SET_ADDRESS ("2", "Dodaj adres zlecenia."),

    SHOW_SHIPMENT_SUMMARY("3", "Wyświetl podsumowanie zlecenia."),

    SEND_SHIPMENT  ("4", "Wyślij przesyłki."),

    MARK_SHIPMENT_AS_DELIVERED  ("5", "Oznacz przesyłki jako doręczone."),

    HELP        ("6", "Wyświetl dostępne opcje.")
    ;

    private final String menuItemName;
    private final String menuItemDescription;

    /**
     * MainMenuItems enum constructor
     */
    MainMenuItems(String menuItemName, String menuItemDescription) {
        this.menuItemName = menuItemName;
        this.menuItemDescription = menuItemDescription;
    }

    /**
     * Returns main menu item name
     */
    @Override
    public String getMenuItemName() {
        return this.menuItemName;
    }

    /**
     * Returns main menu item description
     */
    @Override
    public String getMenuItemDescription() {
        return this.menuItemDescription;
    }
}
