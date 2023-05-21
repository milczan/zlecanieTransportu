package models.menu;

import models.Shipment;
import models.shipmentItems.Container;
import models.shipmentItems.Letter;
import models.shipmentItems.Pallet;

import java.util.Scanner;

/**
 * Menu handler class
 */
public class MenuHandler {
    private static final String PROMPT = "%";
    /**
     * Console Input Scanner
     */
    private Scanner input = new Scanner(System.in);
    private Shipment shipment  = new Shipment();

    /**
     * Handles provided input in the console from the user.
     * @throws IllegalArgumentException if user inputs an invalid command.
     */
   public void handle() throws IllegalArgumentException {
       System.out.printf("\n%s ", PROMPT);
       // Parse user input
       String[] userInput = this.input.nextLine().trim().split("\\s+");

       // Check if user inputs is not blank
       if(userInput.length < 1) {
            return;
       }
       // Get user command form parsed users' input
       String command = userInput[0];
       Menu mainMenu = new MainMenu();
       ShipmentMenu shipmentMenu = new ShipmentMenu();



       // Check if command provided by the user is valid - if shipment menu items or main menu items contains user command.
       if(!menuContains(command)) {
           throw new IllegalArgumentException();
       }

       // Exit app
       if(command.equals(MainMenuItems.EXIT.getMenuItemName())) {
           System.out.println("Do zobaczenia!");
           System.exit(0);
       }
       // Print main menu options
       else if(command.equals(MainMenuItems.HELP.getMenuItemName())) {
           Help.printHelp(mainMenu);
           return;
       }

       // Set shipment address
       if(command.equals(MainMenuItems.SET_ADDRESS.getMenuItemName())) {
           shipment.setAddress();
           Help.printHelp(mainMenu);
       }
       // Add a shipment item to the shipment list
       else if(command.equals(MainMenuItems.ADD_ITEM.getMenuItemName())) {
           Help.printHelp(shipmentMenu);
       }
       // Print shipment summary
       else if(command.equals(MainMenuItems.SHOW_SHIPMENT_SUMMARY.getMenuItemName())){
           shipment.showSummary();
           Help.printHelp(mainMenu);
       }
       // Send all shipment items from shipment list
       else if(command.equals(MainMenuItems.SEND_SHIPMENT.getMenuItemName())) {
           shipment.send();
           Help.printHelp(mainMenu);
       }
       // Mark shipment as delivered
       else if(command.equals(MainMenuItems.MARK_SHIPMENT_AS_DELIVERED.getMenuItemName())) {
           shipment.deliver();
           Help.printHelp(mainMenu);
       }
       // print shipment menu items
       else if(command.equals(ShipmentMenuItems.HELP.getMenuItemName())) {
           Help.printHelp(shipmentMenu);
       }
       // add letter to shipment list
       else if(command.equals(ShipmentMenuItems.LETTER.getMenuItemName())) {
           shipment.addItem(Letter.class);
           Help.printHelp(shipmentMenu);
       }
       // add package to shipment list
       else if(command.equals(ShipmentMenuItems.PACKAGE.getMenuItemName())) {
           shipment.addItem(models.shipmentItems.Package.class);
           Help.printHelp(shipmentMenu);
       }
       // add pallet to shipment list
       else if(command.equals(ShipmentMenuItems.PALLET.getMenuItemName())) {
           shipment.addItem(Pallet.class);
           Help.printHelp(shipmentMenu);
       }
       // add container to shipment list
       else if(command.equals(ShipmentMenuItems.CONTAINER.getMenuItemName())) {
           shipment.addItem(Container.class);
           Help.printHelp(shipmentMenu);
       }
    }

    /**
     * Checks if the MainMenu or ShipmentMenu contains a user's particular choice
     */
    private static boolean menuContains(String choice) {
        for(MainMenuItems m: MainMenuItems.values()) {
            if(m.getMenuItemName().equals(choice)) {
                return true;
            }
        }
        for(ShipmentMenuItems m: ShipmentMenuItems.values()) {
            if(m.getMenuItemName().equals(choice)) {
                return true;
            }
        }
        return false;
    }
}
