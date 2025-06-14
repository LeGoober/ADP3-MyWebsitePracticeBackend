package mywebsite_2.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import mywebsite_2.domain.HomeAddress;
import mywebsite_2.factory.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HomeAddressControllerTest {
    private static HomeAddress homeAddress;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/home_address";

    @BeforeAll
    public static void setup() {
        homeAddress = HomeAddressFactory.createHomeAddress(
                null,
                "123 Main St",
                "Apartment 5",
                "",
                "Cape Town",
                "Western Cape",
                "South Africa",
                111);
    }

    @Test
    @Order(1)
    void createHomeAddress() {
        String url = BASE_URL + "/create";
        ResponseEntity<HomeAddress> response = restTemplate.postForEntity(url, homeAddress, HomeAddress.class);
        assertNotNull(response.getBody());
        homeAddress = response.getBody(); // Store created address
        System.out.println("Created_HomeAddress: " + homeAddress);
    }

    @Test
    @Order(2)
    void readHomeAddress() {
        String url = BASE_URL + "/read/" + homeAddress.getAddressID();
        ResponseEntity<HomeAddress> response = restTemplate.getForEntity(url, HomeAddress.class);
        assertNotNull(response.getBody());
        assertEquals(homeAddress.getAddressID(), response.getBody().getAddressID());
        System.out.println("Read_HomeAddress: " + response.getBody());
    }

    @Test
    @Order(3)
    void updateHomeAddress() {
        HomeAddress updatedHomeAddress = new HomeAddress.Builder()
                .copy(homeAddress)
                .setStreetName("456 Elm St")
                .build();
        String url = BASE_URL + "/update";
        ResponseEntity<?> response = restTemplate.exchange(
                url, HttpMethod.PUT, new HttpEntity<>(updatedHomeAddress), HomeAddress.class);
        assertNotNull(response.getBody());
        assertEquals(updatedHomeAddress.getAddressID(), ((HomeAddress)response.getBody()).getAddressID());
        System.out.println("Updated_HomeAddress: " + response.getBody());
    }

    @Test
    @Order(4)
    void deleteHomeAddress() {
        String url = BASE_URL + "/delete/" + homeAddress.getAddressID();
        restTemplate.delete(url);
        ResponseEntity<?> response = restTemplate.getForEntity(BASE_URL + "/read/" + homeAddress.getAddressID(), HomeAddress.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_HomeAddress: Status " + response.getStatusCode());
    }
}