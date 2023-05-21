package models.shipmentItems;

import strategies.ContainerShipmentStrategy;

import java.math.BigDecimal;

public class Container extends ShipmentItem {
    public Container(Integer weight) {
        super(weight);
        this.type = "Kontener";
        this.price = new BigDecimal(2000.0);
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
        ContainerShipmentStrategy containerShipmentStrategy = new ContainerShipmentStrategy();
        containerShipmentStrategy.send(this);
    }
}
