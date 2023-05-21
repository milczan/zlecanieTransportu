package strategies;

import interfaces.ShipmentStrategyInterface;
import models.shipmentItems.ShipmentItem;

/**
 * Pallet shipment strategy
 */
public class PalletShipmentStrategy implements ShipmentStrategyInterface {
    /**
     * Send pallet
     */
    @Override
    public void send(ShipmentItem shipmentItem) {
        System.out.println("Transport przesyłki samochodem dostawczym: " + shipmentItem.getDetails());
    }
}
