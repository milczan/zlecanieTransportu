package strategies;

import interfaces.ShipmentStrategyInterface;
import models.shipmentItems.ShipmentItem;

/**
 * Letter shipment strategy
 */
public class LetterShipmentStrategy implements ShipmentStrategyInterface {
    /**
     * Send letter
     */
    @Override
    public void send(ShipmentItem shipmentItem) {
        System.out.println("Transport przesyłki samochodem: " + shipmentItem.getDetails());
    }
}
