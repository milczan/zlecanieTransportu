package strategies;

import interfaces.ShipmentStrategyInterface;
import models.shipmentItems.ShipmentItem;

/**
 * Container shipment strategy
 */
public class ContainerShipmentStrategy implements ShipmentStrategyInterface {
    /**
     * Send container
     */
    @Override
    public void send(ShipmentItem shipmentItem) {
        System.out.println("Transport przesyłki statkiem: " + shipmentItem.getDetails());
    }
}
