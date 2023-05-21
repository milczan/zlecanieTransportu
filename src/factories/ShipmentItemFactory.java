package factories;

import models.shipmentItems.*;
import models.shipmentItems.Package;

/**
 * ShipmentItemFactory class to create shipment items
 */
public class ShipmentItemFactory {
    /**
     * create Letter object
     */
    public static ShipmentItem createLetter(int weight, boolean priority, String format) {
        return new Letter(weight, priority, format);
    }

    /**
     * create Package object
     */
    public static ShipmentItem createPackage(int width, int height, int length, int weight){
        return new Package(width, height, length, weight);
    }

    /**
     * create Pallet object
     */
    public static ShipmentItem createPallet(int weight){
        return new Pallet(weight);
    }

    /**
     * create Container object
     */
    public static ShipmentItem createContainer(int weight){
        return new Container(weight);
    }
}