package mywebsite_2.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import mywebsite_2.domain.Customer;
import mywebsite_2.domain.HomeAddress;
import mywebsite_2.factory.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerControllerTest {
    private static Customer customer;
    private static HomeAddress homeAddress;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/customer";

    @BeforeAll
    public static void setup() {
        homeAddress = HomeAddressFactory.createHomeAddress(
                null, "123 Main St", "Apartment 5", "", "Cape Town", "Western Cape", "South Africa", 111);
        customer = CustomerFactory.createCustomer(
                null, "Rorisang", "Makgana", "0123456789", "rori@something.com", homeAddress);
    }

    @Test
    @Order(1)
    void createCustomer() {
        String url = BASE_URL + "/create";
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(response.getBody());
        customer = response.getBody(); // Store created customer
        System.out.println("Created_customer: " + customer);
    }

    @Test
    @Order(2)
    void readCustomer() {
        String url = BASE_URL + "/read/" + customer.getCustomerID();
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertNotNull(response.getBody());
        assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
        System.out.println("Read_Customer: " + response.getBody());
    }

    @Test
    @Order(3)
    void updateCustomer() {
        Customer newUpdatedCustomer = new Customer.Builder()
                .copy(customer).setFirstName("Rori").build();
        String url = BASE_URL + "/update";
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, newUpdatedCustomer, Customer.class);
        assertNotNull(response.getBody());
        assertEquals(newUpdatedCustomer.getCustomerID(), response.getBody().getCustomerID());
        System.out.println("Updated_Customer: " + response.getBody());
    }

    @Test
    @Order(4)
    void deleteCustomer() {
        String url = BASE_URL + "/delete/" + customer.getCustomerID();
        restTemplate.delete(url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(BASE_URL + "/read/" + customer.getCustomerID(), Customer.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        System.out.println("Deleted_Customer: Status " + response.getStatusCode());
    }
}