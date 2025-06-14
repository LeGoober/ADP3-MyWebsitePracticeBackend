package mywebsite_2.factory;

import mywebsite_2.domain.HomeAddress;
import mywebsite_2.util.Helper;

public class HomeAddressFactory {
    public static HomeAddress createHomeAddress(
            Long addressID,
            String streetNumber,
            String streetName,
            String suburb,
            String city,
            String province,
            String country,
            int postalCode
    ) {
        if (Helper.isNullOrEmpty(streetNumber) ||
                Helper.isNullOrEmpty(streetName) ||
                Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(country)) {
            return null;
        }
        return new HomeAddress.Builder()
                .setAddressID(null) // Let JPA generate ID
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setCity(city)
                .setProvince(province)
                .setCountry(country)
                .setPostalCode(postalCode)
                .build();
    }
}