package models.shipmentItems;

import interfaces.ShippableInterface;

import java.math.BigDecimal;

public abstract class ShipmentItem implements ShippableInterface {
    protected String type;
    private Integer weight;
    protected BigDecimal price;

    public ShipmentItem(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String getType() { return type; }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public abstract String getDetails();

    public abstract void send();
}
