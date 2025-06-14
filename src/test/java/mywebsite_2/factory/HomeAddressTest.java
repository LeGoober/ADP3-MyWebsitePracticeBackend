package mywebsite_2.factory;

import mywebsite_2.domain.HomeAddress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HomeAddressFactoryTest {
    @Test
    void createHomeAddress() {
        HomeAddress homeAddress = HomeAddressFactory.createHomeAddress(
                null,
                "12",
                "Frieza St",
                "Jenkins",
                "Home City",
                "Lander Province",
                "South Hughy",
                7945);
        assertNotNull(homeAddress);
        System.out.println(homeAddress);
    }

    @Test
    void createHomeAddressWithNullStreetNumber() {
        HomeAddress homeAddress = HomeAddressFactory.createHomeAddress(
                null,
                null,
                "Frieza St",
                "Jenkins",
                "Home City",
                "Lander Province",
                "South Hughy",
                7945);
        assertNull(homeAddress, "Should return null for null streetNumber");
    }
}