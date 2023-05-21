package models.menu;

import java.util.Arrays;

/**
 * Shipment Menu class
 */
public class ShipmentMenu extends Menu{
    /**
     * Print all available shipment menu items, defined in ShipmentMenuItems enum
     */
    @Override
    public void printMenu() {
        Arrays.asList(ShipmentMenuItems.values()).forEach(item ->
                System.out.printf("%-5s- %s\n", item.getMenuItemName(), item.getMenuItemDescription()));
    }
}
