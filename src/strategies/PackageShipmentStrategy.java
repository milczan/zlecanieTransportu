package strategies;

import interfaces.ShipmentStrategyInterface;
import models.shipmentItems.ShipmentItem;

/**
 * Package shipment strategy
 */
public class PackageShipmentStrategy implements ShipmentStrategyInterface {
    /**
     * Send package
     */
    @Override
    public void send(ShipmentItem shipmentItem) {
        System.out.println("Transport przesyłki busem: " + shipmentItem.getDetails());
    }
}
