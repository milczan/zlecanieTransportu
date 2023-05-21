package models.shipmentItems;

import strategies.LetterShipmentStrategy;

import java.math.BigDecimal;

public class Letter extends ShipmentItem {
    private boolean priority;

    private String format;
    public Letter(Integer weight, boolean priority, String format) {
        super(weight);
        this.type = "List";
        this.priority = priority;
        this.format = format;
        if (format == "S") {
            this.price = new BigDecimal(10.0);
        }
        else if (format == "M") {
            this.price = new BigDecimal(20.0);
        }
        else if (format == "L") {
            this.price = new BigDecimal(30.0);
        }
        else {
            this.price = new BigDecimal(40.0);
        }
    }

    public boolean isPriority() {
        return priority;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String getDetails() {
        return getType() +
                " {waga='" + getWeight() + " kg" + '\'' +
                ", format='" + getFormat() + '\'' +
                ", priorytet='" + (isPriority() ? "tak" : "nie") + '\'' +
                ", cena='" + getPrice() + " PLN" + '\'' +
                '}';
    }

    @Override
    public void send() {
        LetterShipmentStrategy letterShipmentStrategy = new LetterShipmentStrategy();
        letterShipmentStrategy.send(this);
    }
}
