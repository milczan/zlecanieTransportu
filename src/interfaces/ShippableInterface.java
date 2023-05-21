package interfaces;

import java.math.BigDecimal;

/**
 * Shippable interface
 */
public interface ShippableInterface {
    /**
     * Returns shipment item weight
     */
    Integer getWeight();
    /**
     * Returns shipment item details
     */
    String getDetails();
    /**
     * Returns shipment item type
     */
    String getType();
    /**
     * Returns shipment item price
     */
    BigDecimal getPrice();
    /**
     * Send shipment item
     */
    void send();
}
