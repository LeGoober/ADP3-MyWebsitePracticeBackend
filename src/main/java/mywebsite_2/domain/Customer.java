package mywebsite_2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    @OneToOne
    @JoinColumn(name = "address_id")
    private HomeAddress homeAddress;

    protected Customer() {
    }

    protected Customer(Builder builder) {
        this.customerID = builder.customerID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.homeAddress = builder.homeAddress;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    // Add getter for homeAddress
    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    // Add setter for homeAddress (optional, if updates are needed)
    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "Customer_Details:{ \n" +
                "Customer_ID: " + customerID + ", \n" +
                "First_Name: " + firstName + ", \n" +
                "Last_Name: " + lastName + ", \n" +
                "Email_Address: " + email + ", \n" +
                "Mobile_Number: " + mobileNumber + ", \n" +
                "HomeAddress: " + homeAddress + "}";
    }

    public static class Builder {
        private String customerID;
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private HomeAddress homeAddress;

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setHomeAddress(HomeAddress homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerID = customer.customerID; // Fix: Use customer.getCustomerID() or customer.customerID
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.mobileNumber = customer.mobileNumber;
            this.homeAddress = customer.homeAddress;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}