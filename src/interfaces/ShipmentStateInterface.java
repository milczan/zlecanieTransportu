package interfaces;

import models.Shipment;

/**
 * Shipment status interface
 */
public interface ShipmentStateInterface {
    /**
     * Update shipment status
     */
    void updateStatus(Shipment shipment);

    /**
     * Print shipment status
     */
    void displayStatus();
}