package models.menu;

import interfaces.MenuItemInterface;

/**
 * Shipment menu items class
 */
public enum ShipmentMenuItems implements MenuItemInterface {
    /**
     * Available shipment menu options
     */
    MAIN_MENU        ("6", "Powrót do menu głównego."),

    LETTER    ("L", "Dodaj list."),

    PACKAGE    ("P", "Dodaj paczkę."),

    PALLET  ("PA", "Dodaj paletę."),

    CONTAINER ("K", "Dodaj kontener."),

    HELP        ("7", "Wyświetl dostępne opcje dodawania przesyłki.")
    ;
    private final String menuItemName;
    private final String menuItemDescription;

    /**
     * Shipment menu enum constructor
     */
    ShipmentMenuItems(String menuItemName, String menuItemDescription) {
        this.menuItemName = menuItemName;
        this.menuItemDescription = menuItemDescription;
    }

    /**
     * Returns shipment menu item name
     */
    @Override
    public String getMenuItemName() {
        return this.menuItemName;
    }

    /**
     * Returns shipment menu item description
     */
    @Override
    public String getMenuItemDescription() {
        return this.menuItemDescription;
    }
}
