package models;

import interfaces.ShipmentAddressInterface;

/**
 * Shipment address class
 */
public class ShipmentAddress implements ShipmentAddressInterface {
    private String street;
    private String number;
    private String city;
    private String country;
    private String postCode;
    private final String type;

    /**
     * Shipment address constructor
     */
    public ShipmentAddress(String type) {
        this.type = type;
    }

    /**
     * Returns address street
     */
    @Override
    public String getStreet() {
        return street;
    }

    /**
     * Returns address building number
     */
    @Override
    public String getNumber() {
        return number;
    }

    /**
     * Returns address city
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * Returns address country
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * Returns address postcode
     */
    @Override
    public String getPostCode() {
        return postCode;
    }

    /**
     * Returns address type sender/receiver
     */
    @Override
    public String getType() { return type; }

    /**
     * Set address street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Set address building number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Set address city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set address country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set address postcode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Verify if address is valid - all attributes can't be null and can't be blank
     */
    @Override
    public boolean isValidAddress() {
        return country != null && city != null && street != null && postCode != null &&
        !country.isEmpty() && !city.isBlank() && !street.isBlank() && !postCode.isBlank();
    }

    /**
     * Returns shipment address object's attributes values as string
     */
    @Override
    public String toString() {
        return getType() +
                " {" +
                "kraj='" + getCountry() + '\'' +
                ", miejscowość='" + getCity() + '\'' +
                ", ulica='" + getStreet() + '\'' +
                ", numer budynku='" + getNumber() + '\'' +
                ", kod pocztowy='" + getPostCode() + '\'' +
                '}';
    }

}
