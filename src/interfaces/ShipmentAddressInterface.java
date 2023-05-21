package interfaces;

/**
 * Shippment address interface
 */
public interface ShipmentAddressInterface {
    /**
     * Returns address street
     */
    String getStreet();
    /**
     * Returns address building number
     */
    String getNumber();
    /**
     * Returns address city
     */
    String getCity();
    /**
     * Returns address country
     */
    String getCountry();
    /**
     * Returns address post code
     */
    String getPostCode();
    /**
     * Returns address type e.g. sender/receiver
     */
    String getType();
    /**
     * Verify if address is valid
     */
    boolean isValidAddress();
}
