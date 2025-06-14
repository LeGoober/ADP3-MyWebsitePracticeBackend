package mywebsite_2.services;

import mywebsite_2.domain.HomeAddress;
import mywebsite_2.repository.HomeAddressRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeAddressService implements IHomeAddress {
    private final HomeAddressRepository homeAddressRepository;

    @Autowired
    public HomeAddressService(HomeAddressRepository homeAddressRepository) {
        this.homeAddressRepository = homeAddressRepository;
    }

    @Override
    public Optional<HomeAddress> findHomeAddressByID(Long homeAddressID) {
        return homeAddressRepository.findById(homeAddressID); // Use findById
    }

    @Override
    public HomeAddress createHomeAddress(HomeAddress address) {
        return homeAddressRepository.save(address);
    }

    @Override
    public HomeAddress readHomeAddress(Long homeAddressID) {
        return homeAddressRepository.findById(homeAddressID).orElse(null);
    }

    @Override
    public HomeAddress updateHomeAddress(HomeAddress homeAddress) {
        return homeAddressRepository.save(homeAddress); // Save updated object
    }

    @Override
    public void deleteHomeAddress(Long homeAddressID) {
        homeAddressRepository.deleteById(homeAddressID);
    }
}