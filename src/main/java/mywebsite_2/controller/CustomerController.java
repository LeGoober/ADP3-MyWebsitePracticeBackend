package mywebsite_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mywebsite_2.domain.Customer;
import mywebsite_2.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/read/{customerID}")
    public Customer readCustomer(@PathVariable String customerID) {
        return customerService.readCustomer(customerID);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{customerID}")
    public void deleteCustomer(@PathVariable String customerID) {
        customerService.deleteCustomer(customerID);
    }
}