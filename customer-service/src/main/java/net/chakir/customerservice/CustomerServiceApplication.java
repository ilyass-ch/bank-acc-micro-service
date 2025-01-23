package net.chakir.customerservice;

import net.chakir.customerservice.config.GlobalConfig;
import net.chakir.customerservice.entities.Customer;
import net.chakir.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {

            Customer customer1 = new Customer(null,"ilyass", "chakir", "ilyass@gmail.com");
            Customer customer2 = new Customer(null,"monsef", "chakir", "monsef@gmail.com");
            Customer customer3 = new Customer(null,"sami", "redouani", "sam@gmail.com");

            customerRepository.save(customer1); // L'ID est généré ici
            customerRepository.save(customer2);

            customerRepository.save(customer3);

        };
    }

}
