package org.frh.accountservice.web;

import org.frh.accountservice.clients.CustomerRestClient;
import org.frh.accountservice.entity.Account;
import org.frh.accountservice.model.Customer;
import org.frh.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountRepository accountRepository;

    //Feign
    private CustomerRestClient customerRestClient;

    public AccountRestController(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<Account> accountList(){
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account accountById(@PathVariable String id){

        Account account =  accountRepository.findById(id).orElseThrow();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }
}
