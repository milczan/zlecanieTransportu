package states;

import interfaces.ShipmentStateInterface;
import models.Shipment;

/**
 * shipment status - in transit
 */
public class InTransitShipmentState implements ShipmentStateInterface {
    /**
     * Update shipment status - set next available status - delivered
     */
    @Override
    public void updateStatus(Shipment shipment) {
        shipment.setShipmentStatus(new DeliveredShipmentState());
    }

    /**
     * print shipment status
     */
    @Override
    public void displayStatus() {
        System.out.println("Status zlecenia: W transporcie");
    }
}