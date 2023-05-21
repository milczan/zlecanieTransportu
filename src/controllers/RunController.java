package controllers;

import models.menu.Help;
import models.menu.MainMenu;
import models.menu.MenuHandler;

public class RunController {
    /**
     * Class to run program
     */
    public void run() {
        Help.printHelp(new MainMenu());
        MenuHandler menuHandler = new MenuHandler();

        while(true) {
            try {
                menuHandler.handle();
            } catch(Exception e) {
                System.err.println("Nie rozpoznano polecenia. Spróbuj ponownie.");
            }
        }
    }
}
