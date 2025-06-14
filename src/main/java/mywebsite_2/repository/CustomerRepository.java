package mywebsite_2.repository;

import mywebsite_2.domain.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByCustomerID(); // Fixed naming
    // Remove redundant methods, as JpaRepository provides save(), findById(), deleteById()
}