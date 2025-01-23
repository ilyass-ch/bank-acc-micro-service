package net.chakir.customerservice.repository;

import net.chakir.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {




}
