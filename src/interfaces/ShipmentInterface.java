package interfaces;

import models.shipmentItems.ShipmentItem;

import java.math.BigDecimal;

/**
 * Shipment interface
 */
public interface ShipmentInterface {
    /**
     * Add shipment item to shipment list
     */
    void addItem(Class<? extends ShipmentItem> shipmentClass);

    /**
     * Set shipment status
     */
    void setShipmentStatus(ShipmentStateInterface shipmentStatus);

    /**
     * Update shipment status
     */
    void updateStatus();

    /**
     * Print shipment status
     */
    void displayStatus();

    /**
     * Print shipment details
     */
    void showSummary();

    /**
     * Set shipment address
     */
    void setAddress();

    /**
     * Send shipment
     */
    void send();

    /**
     * Mark shipment as delivered
     */
    void deliver();

    /**
     * Calculate shipment total costs
     */
    BigDecimal calculateShipmentPrice();

    /**
     * Print shipment total costs
     */
    void displayPrice();
}
