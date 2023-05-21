package models;

import factories.ShipmentItemFactory;
import interfaces.ShipmentInterface;
import interfaces.ShipmentStateInterface;
import models.shipmentItems.Container;
import models.shipmentItems.Letter;
import models.shipmentItems.Pallet;
import models.shipmentItems.Package;
import models.shipmentItems.ShipmentItem;
import states.CreatedShipmentState;
import states.InTransitShipmentState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Shipment class
 */
public class Shipment implements ShipmentInterface {
    /**
     * Shipment items list - contains shipment item objects e.g. letters, packages, pallets, containers
     */
    private List<ShipmentItem> shipmentItems = new ArrayList<>();
    /**
     * Shipment's sender address
     */
    private ShipmentAddress senderAddress = new ShipmentAddress("Adres nadawcy");
    /**
     * Shipment's receiver address
     */
    private ShipmentAddress receiverAddress = new ShipmentAddress("Adres odbiorcy");
    /**
     * Console Input Scanner
     */
    private Scanner input = new Scanner(System.in);
    /**
     * Shipment's current status
     */
    private ShipmentStateInterface shipmentStatus;

    /**
     * Shipment's class constructor - set default shipment status - shipment created
     */
    public Shipment() {
        shipmentStatus = new CreatedShipmentState();
    }

    /**
     * Add shipment item (letter, package, pallet, container) to shipment items list
     */
    @Override
    public void addItem(Class<? extends ShipmentItem> shipmentClass) {
        ShipmentItem shipmentItem = null;
        try {
            System.out.println("Podaj wagę przesyłki [kg]:");
            int weight = Integer.parseInt(input.nextLine());

            if (Letter.class.equals(shipmentClass)) {
                System.out.println("Podaj format listu: S/M/L:");
                String format = input.nextLine();
                System.out.println("Czy list priorytetowy? t/n:");
                String isPriority = input.nextLine();
                boolean priority = (isPriority.equals("t")) ? true : false;
                shipmentItem = ShipmentItemFactory.createLetter(weight, priority, format);

            }
            else if (Container.class.equals(shipmentClass)) {
                shipmentItem = ShipmentItemFactory.createContainer(weight);
            }
            else if (Package.class.equals(shipmentClass)) {
                System.out.println("Podaj szerokość paczki [cm]:");
                int width = Integer.parseInt(input.nextLine());
                System.out.println("Podaj wysokość paczki [cm]:");
                int height = Integer.parseInt(input.nextLine());
                System.out.println("Podaj długość paczki [cm]:");
                int length = Integer.parseInt(input.nextLine());
                shipmentItem = ShipmentItemFactory.createPackage(width, height, length, weight);
            }
            else if (Pallet.class.equals(shipmentClass)) {
                shipmentItem = ShipmentItemFactory.createPallet(weight);
            }
            shipmentItems.add(shipmentItem);
            System.out.println(shipmentItem.getDetails() + " został(a) dodany(a) do zlecenia");
        } catch (NumberFormatException e) {
            System.out.println("Nieprawidłowa wartość liczbowa. Spróbuj ponownie.");
        }
    }

    /**
     * Set shipment's status
     */
    @Override
    public void setShipmentStatus(ShipmentStateInterface shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    /**
     * Update shipment's status to next available status from the defined status list
     */
    @Override
    public void updateStatus() {
        shipmentStatus.updateStatus(this);
    }

    /**
     * Print current shipment status
     */
    @Override
    public void displayStatus() {
        shipmentStatus.displayStatus();
    }

    /**
     * Print details of shipment - shipment items, total shipment costs, shipment addresses
     */
    @Override
    public void showSummary() {
        System.out.println("Lista przesyłek w zleceniu");
        for (ShipmentItem shipmentItem: shipmentItems) {
            System.out.println(shipmentItem.getDetails());
        }
        System.out.println(senderAddress.toString());
        System.out.println(receiverAddress.toString());
        displayPrice();
    }

    /**
     * Set shipment addresses
     */
    public void setAddress() {
        System.out.println("Podaj kraj nadawcy:");
        String senderCountry = input.nextLine();
        senderAddress.setCountry(senderCountry);

        System.out.println("Podaj miejscowość nadawcy:");
        String senderCity = input.nextLine();
        senderAddress.setCity(senderCity);

        System.out.println("Podaj ulicę nadawcy:");
        String senderStreet = input.nextLine();
        senderAddress.setStreet(senderStreet);

        System.out.println("Podaj numer budynku nadawcy:");
        String senderBuildingNumber = input.nextLine();
        senderAddress.setNumber(senderBuildingNumber);

        System.out.println("Podaj kod pocztowy nadawcy:");
        String senderPostCode = input.nextLine();
        senderAddress.setPostCode(senderPostCode);

        System.out.println("Dodano " + senderAddress.toString());

        System.out.println("Podaj kraj odbiorcy:");
        String receiverCountry = input.nextLine();
        receiverAddress.setCountry(receiverCountry);

        System.out.println("Podaj miejscowość odbiorcy:");
        String receiverCity = input.nextLine();
        receiverAddress.setCity(receiverCity);

        System.out.println("Podaj ulicę odbiorcy:");
        String receiverStreet = input.nextLine();
        receiverAddress.setStreet(receiverStreet);

        System.out.println("Podaj numer budynku odbiorcy:");
        String receiverBuildingNumber = input.nextLine();
        receiverAddress.setNumber(receiverBuildingNumber);

        System.out.println("Podaj kod pocztowy odbiorcy:");
        String receiverPostCode = input.nextLine();
        receiverAddress.setPostCode(receiverPostCode);

        System.out.println("Dodano " + receiverAddress.toString());
    }

    /**
     * Send all shipment items from the shipment list
     */
    @Override
    public void send() {
        if (senderAddress.isValidAddress() && receiverAddress.isValidAddress()) {
            for (ShipmentItem shipmentItem : this.shipmentItems) {
                shipmentItem.send();
            }
            updateStatus();
            displayStatus();
        } else {
            System.err.println("Nie można wysłać przesyłek. Proszę ustawić poprawny adres nadawcy i odbiorcy zlecenia.");
        }
    }

    /**
     * Deliver shipment
     */
    @Override
    public void deliver() {
        if (shipmentStatus instanceof InTransitShipmentState) {
            updateStatus();
            displayStatus();
        } else {
            System.err.println("Nie można oznaczyć przesyłek jako doręczone. Proszę najpierw wysłać przesyłki.");
        }
    }

    /**
     * Calculate total shipment's costs
     */
    @Override
    public BigDecimal calculateShipmentPrice() {
        BigDecimal priceSum = new BigDecimal(0.0);
        for (ShipmentItem shipmentItem : this.shipmentItems) {
            priceSum = priceSum.add(shipmentItem.getPrice());
        }
        return priceSum;
    }

    /**
     * Print shipment price
     */
    @Override
    public void displayPrice() {
        BigDecimal totalShipmentCosts = calculateShipmentPrice();
        System.out.println("Łaczny koszt transportu przesyłek: " + totalShipmentCosts + " PLN");
    }
}
