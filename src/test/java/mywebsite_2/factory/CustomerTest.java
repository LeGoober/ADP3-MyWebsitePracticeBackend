package mywebsite_2.factory;

import mywebsite_2.domain.Customer;
import mywebsite_2.domain.HomeAddress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    @Test
    void createCustomer() {
        HomeAddress address = HomeAddressFactory.createHomeAddress(
                1L,
                "22",
                "Sunset Blvd",
                "Sea Point",
                "Cape Town",
                "Western Cape",
                "South Africa",
                8005);
        Customer customer = CustomerFactory.createCustomer(
                "12345",
                "Saurez",
                "Gomez",
                "067 977 4738",
                "gooning12@gmail.com", address);
        assertNotNull(customer);
        System.out.println(customer);
    }
}