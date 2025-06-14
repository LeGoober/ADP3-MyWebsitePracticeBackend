package mywebsite_2.factory;

import mywebsite_2.domain.Customer;
import mywebsite_2.domain.HomeAddress;
import mywebsite_2.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer(
            String customerID,
            String firstName,
            String lastName,
            String mobileNumber,
            String email,
            HomeAddress homeAddress
    ) {
        if (Helper.isNullOrEmpty(customerID) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email)) {
            return null;
        }
        return new Customer.Builder()
                .setCustomerID(customerID) // Consider omitting if JPA generates ID
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email) // Fixed
                .setMobileNumber(mobileNumber) // Fixed
                .setHomeAddress(homeAddress)
                .build();
    }
}