package mywebsite_2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "HomeAddress")
public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;
    private String streetNumber;
    private String streetName;
    private String suburb;
    private String city;
    private String province; // Added to main class
    private String country;
    private int postalCode;

    // Explicit default constructor for JPA
    protected HomeAddress() {
    }

    protected HomeAddress(Builder builder) {
        this.addressID = builder.addressID;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.province = builder.province; // Added
        this.country = builder.country;
        this.postalCode = builder.postalCode;
    }

    public Long getAddressID() {
        return addressID;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() { // Added getter
        return province;
    }

    public String getCountry() {
        return country;
    }

    public int getPostalCode() { // Keep one getter, removed getPostcode
        return postalCode;
    }

    @Override
    public String toString() {
        return "HomeAddress{" +
                "addressID=" + addressID +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder {
        private Long addressID;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String city;
        private String province;
        private String country;
        private int postalCode;

        public Builder setAddressID(Long addressID) {
            this.addressID = addressID;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(HomeAddress homeAddress) {
            this.addressID = homeAddress.addressID;
            this.streetNumber = homeAddress.streetNumber;
            this.streetName = homeAddress.streetName;
            this.suburb = homeAddress.suburb;
            this.city = homeAddress.city;
            this.province = homeAddress.province;
            this.country = homeAddress.country;
            this.postalCode = homeAddress.postalCode;
            return this;
        }

        public HomeAddress build() {
            return new HomeAddress(this);
        }
    }
}