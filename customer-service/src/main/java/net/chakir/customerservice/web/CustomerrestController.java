package net.chakir.customerservice.web;

import lombok.AllArgsConstructor;
import net.chakir.customerservice.entities.Customer;
import net.chakir.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerrestController {

    private CustomerRepository customerRepository;


    public CustomerrestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> CustomerList() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer CustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            System.out.println("Customer not found with id: " + id);
        } else {
            System.out.println("Found customer: " + customer);
        }
        return customer;
    }

}
