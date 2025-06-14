package mywebsite_2.services;

import mywebsite_2.domain.HomeAddress;
import mywebsite_2.factory.HomeAddressFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HomeAddressServiceTest {
    @Autowired
    private HomeAddressService homeAddressService;

    private HomeAddress houseAddress = HomeAddressFactory.createHomeAddress(
            null, "91", "Rochester Road", "Observatory", "Cape Town", "Western Cape", "South Africa", 8080);

    @Test
    @Order(1)
    void createHomeAddress() {
        HomeAddress createdHomeAddress = homeAddressService.createHomeAddress(houseAddress);
        assertNotNull(createdHomeAddress);
        this.houseAddress = createdHomeAddress; // Store for later tests
        System.out.println(createdHomeAddress);
    }

    @Test
    @Order(2)
    void readHomeAddress() {
        HomeAddress readHomeAddress = homeAddressService.readHomeAddress(houseAddress.getAddressID());
        assertNotNull(readHomeAddress);
        System.out.println(readHomeAddress);
    }

    @Test
    @Order(3)
    void updateHomeAddress() {
        HomeAddress newHomeAddress = new HomeAddress.Builder()
                .copy(houseAddress)
                .setStreetName("Burberry Ave")
                .build();
        HomeAddress updatedHomeAddress = homeAddressService.updateHomeAddress(newHomeAddress);
        assertNotNull(updatedHomeAddress);
        System.out.println(updatedHomeAddress);
    }

    @Test
    @Order(4)
    void deleteHomeAddress() {
        homeAddressService.deleteHomeAddress(houseAddress.getAddressID());
        HomeAddress deletedHomeAddress = homeAddressService.readHomeAddress(houseAddress.getAddressID());
        assertNull(deletedHomeAddress);
    }
}