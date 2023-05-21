package models.shipmentItems;

import strategies.PalletShipmentStrategy;

import java.math.BigDecimal;

public class Pallet extends ShipmentItem {
    public Pallet(Integer weight) {
        super(weight);
        this.type = "Paleta";
        this.price = new BigDecimal(1000.0);
    }

    @Override
    public String getDetails() {
        return getType() +
                " {waga='" + getWeight() + " kg" + '\'' +
                ", cena='" + getPrice() + " PLN" + '\'' +
                '}';
    }

    @Override
    public void send() {
        PalletShipmentStrategy palletShipmentStrategy = new PalletShipmentStrategy();
        palletShipmentStrategy.send(this);
    }
}
