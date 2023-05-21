package models.shipmentItems;

import strategies.PackageShipmentStrategy;

import java.math.BigDecimal;

public class Package extends ShipmentItem {
    private Integer width;
    private Integer height;
    private Integer length;
    public Package(Integer width, Integer height, Integer length, Integer weight) {
        super(weight);
        this.width = width;
        this.height = height;
        this.length = length;
        this.type = "Paczka";
        this.price = new BigDecimal(50.0);
    }

    @Override
    public String getDetails() {
        return getType() +
                " {szerokość='" + getWidth() + " cm" + '\'' +
                ", wysokość='" + getHeight() + " cm" + '\'' +
                ", długość='" + getLength() + " cm" + '\'' +
                ", waga='" + getWeight() + " kg" + '\'' +
                ", cena='" + getPrice() + " PLN" + '\'' +
                '}';
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getLength() { return length;}

    @Override
    public void send() {
        PackageShipmentStrategy packageShipmentStrategy = new PackageShipmentStrategy();
        packageShipmentStrategy.send(this);
    }
}
