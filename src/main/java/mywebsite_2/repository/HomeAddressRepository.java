package mywebsite_2.repository;

import mywebsite_2.domain.HomeAddress;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAddressRepository extends JpaRepository<HomeAddress, Long> {
    Optional<HomeAddress> findByAddressID(); // Fixed naming
    // Remove redundant methods, as JpaRepository provides save(), findById(), deleteById()
}