package org.frh.accountservice;

import org.frh.accountservice.entity.Account;
import org.frh.accountservice.enums.AccountType;
import org.frh.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {
            List<Account> accountList = List.of(
                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(1111)
                            .createdAt(LocalDate.now())
                            .type(AccountType.CURRENT_ACCOUNT)
                            .customerId(1L)
                            .build(),

                    Account.builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(2222)
                            .createdAt(LocalDate.now())
                            .type(AccountType.SAVING_ACCOUNT)
                            .customerId(2L)
                            .build()
            );

            accountRepository.saveAll(accountList);
        };
    }
}
