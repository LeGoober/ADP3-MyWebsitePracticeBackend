package mywebsite_2.services;

import mywebsite_2.domain.Customer;
import mywebsite_2.repository.CustomerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findCustomerByID() {
        return customerRepository.findByCustomerID(); // Implement
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer readCustomer(String customerID) {
        return customerRepository.findById(customerID).orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer); // Save updated object
    }

    @Override
    public void deleteCustomer(String customerID) {
        customerRepository.deleteById(customerID);
    }
}