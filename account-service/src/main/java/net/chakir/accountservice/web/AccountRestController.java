package net.chakir.accountservice.web;

import net.chakir.accountservice.clients.CustomerRestClient;
import net.chakir.accountservice.entities.BankAccount;
import net.chakir.accountservice.model.Customer;
import net.chakir.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> BankAccounts() {


        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(acc ->{
            acc.setCustomer(customerRestClient.customerById(acc.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount bankAccount =  bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.customerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
