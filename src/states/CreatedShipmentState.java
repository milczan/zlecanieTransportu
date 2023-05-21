package states;

import interfaces.ShipmentStateInterface;
import models.Shipment;

/**
 * Shipment status - created
 */
public class CreatedShipmentState implements ShipmentStateInterface {
    /**
     * Update shipment status - set next available status - in transit
     */
    @Override
    public void updateStatus(Shipment shipment) {
        shipment.setShipmentStatus(new InTransitShipmentState());
    }

    /**
     * Print current shipment status
     */
    @Override
    public void displayStatus() {
        System.out.println("Status zlecenia: Utworzono zlecenie");
    }
}