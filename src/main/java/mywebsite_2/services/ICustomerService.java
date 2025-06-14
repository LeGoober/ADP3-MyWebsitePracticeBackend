package mywebsite_2.services;

import java.util.Optional;
import mywebsite_2.domain.Customer;

public interface ICustomerService {
    Optional<Customer> findCustomerByID();
    Customer createCustomer(Customer customer);
    Customer readCustomer(String customerID);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(String customerID); // Fixed parameter name
}