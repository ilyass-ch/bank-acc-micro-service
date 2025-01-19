package net.chakir.accountservice;

import net.chakir.accountservice.entities.BankAccount;
import net.chakir.accountservice.enums.AccountType;
import net.chakir.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository) {
        return args -> {
            BankAccount bankAccount1 = new BankAccount(
                    UUID.randomUUID().toString(),
                    90000,
                    LocalDate.now(),
                    "MAD",
                    AccountType.CURRENT_ACCOUNT,
                    null,
                    Long.valueOf(1)
            );
            BankAccount bankAccount2 = new BankAccount(
                    UUID.randomUUID().toString(),
                    120000,
                    LocalDate.now(),
                    "MAD",
                    AccountType.SAVING_ACCOUNT,
                    null,
                    Long.valueOf(2)
            );


            accountRepository.save(bankAccount1);
            accountRepository.save(bankAccount2);
        };
    }

}
