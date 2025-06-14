package mywebsite_2.services;

import mywebsite_2.domain.Customer;
import mywebsite_2.domain.HomeAddress;
import mywebsite_2.factory.CustomerFactory;
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
class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    private HomeAddress houseAddress = HomeAddressFactory.createHomeAddress(
            null, "91", "Rochester Road", "Observatory", "Cape Town", "Western Cape", "South Africa", 8080);
    private Customer customer = CustomerFactory.createCustomer(
            null, "Rorisang", "Makgana", "0321115612", "rorisangmakganaiv@gmail.com", houseAddress);

    @Test
    @Order(1)
    void createCustomer() {
        Customer createdCustomer = customerService.createCustomer(customer);
        assertNotNull(createdCustomer);
        this.customer = createdCustomer; // Store for later tests
        System.out.println(createdCustomer);
    }

    @Test
    @Order(2)
    void readCustomer() {
        Customer readCustomer = customerService.readCustomer(customer.getCustomerID());
        assertNotNull(readCustomer);
        System.out.println(readCustomer);
    }

    @Test
    @Order(3)
    void updateCustomer() {
        Customer updatedCustomer = new Customer.Builder()
                .copy(customer)
                .setEmail("rorisang_makganaiv@gmail.com")
                .build();
        updatedCustomer = customerService.updateCustomer(updatedCustomer);
        assertNotNull(updatedCustomer);
        System.out.println(updatedCustomer);
    }

    @Test
    @Order(4)
    void deleteCustomer() {
        customerService.deleteCustomer(customer.getCustomerID());
        Customer deletedCustomer = customerService.readCustomer(customer.getCustomerID());
        assertNull(deletedCustomer);
    }
}