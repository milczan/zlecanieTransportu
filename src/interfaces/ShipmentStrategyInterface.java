package interfaces;

import models.shipmentItems.ShipmentItem;

/**
 * Shipment Strategy interface
 */
public interface ShipmentStrategyInterface {
    /**
     * Send all package items from shipment list
     */
    void send(ShipmentItem shipmentItem);
}
