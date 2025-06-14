package mywebsite_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mywebsite_2.domain.HomeAddress;
import mywebsite_2.services.HomeAddressService;

@RestController
@RequestMapping("/home_address")
public class HomeAddressController {
    private final HomeAddressService homeAddressService;

    @Autowired
    public HomeAddressController(HomeAddressService homeAddressService) {
        this.homeAddressService = homeAddressService;
    }

    @PostMapping("/create")
    public HomeAddress createHomeAddress(@RequestBody HomeAddress homeAddress) {
        return homeAddressService.createHomeAddress(homeAddress);
    }

    @GetMapping("/read/{homeAddressID}")
    public HomeAddress readHomeAddress(@PathVariable Long homeAddressID) {
        return homeAddressService.readHomeAddress(homeAddressID);
    }

    @PutMapping("/update")
    public HomeAddress updatHomeAddress(@RequestBody HomeAddress homeAddress) {
        return homeAddressService.updateHomeAddress(homeAddress);
    }

    @DeleteMapping("/delete/{homeAddressID}")
    public void deleteHomeAddressByID(@PathVariable Long homeAddressID) {
        homeAddressService.deleteHomeAddress(homeAddressID);
    }
}