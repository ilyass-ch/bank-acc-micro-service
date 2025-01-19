package net.chakir.accountservice.entities;

import jakarta.persistence.*;
import net.chakir.accountservice.enums.AccountType;
import net.chakir.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING )
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

    public BankAccount(String accountId, double balance, LocalDate createdAt, String currency, AccountType type, Customer customer, Long customerId) {
        this.accountId = accountId;
        this.balance = balance;
        this.createdAt = createdAt;
        this.currency = currency;
        this.type = type;
        this.customer = customer;
        this.customerId = customerId;
    }

    public BankAccount() {}

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", customer=" + customer +
                ", customerId=" + customerId +
                '}';
    }
}
