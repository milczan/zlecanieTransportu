package states;

import interfaces.ShipmentStateInterface;
import models.Shipment;

/**
 * shipment status - delivered
 */
public class DeliveredShipmentState implements ShipmentStateInterface {
    @Override
    public void updateStatus(Shipment shipment) {
        // No further status change after delivery
    }

    /**
     * print shipment status
     */
    @Override
    public void displayStatus() {
        System.out.println("Status zlecenia: Dostarczono");
    }
}