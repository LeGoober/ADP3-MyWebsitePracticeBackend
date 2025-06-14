package mywebsite_2.services;

import java.util.Optional;
import mywebsite_2.domain.HomeAddress;

public interface IHomeAddress {
    Optional<HomeAddress> findHomeAddressByID(Long homeAddressID); // Fixed parameter
    HomeAddress createHomeAddress(HomeAddress address); // Fixed typo
    HomeAddress readHomeAddress(Long homeAddressID); // Fixed typo
    HomeAddress updateHomeAddress(HomeAddress homeAddress); // Fixed typo
    void deleteHomeAddress(Long homeAddressID); // Fixed name for consistency
}