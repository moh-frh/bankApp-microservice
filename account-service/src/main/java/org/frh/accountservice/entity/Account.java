package org.frh.accountservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.frh.accountservice.enums.AccountType;
import org.frh.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    //Do NOT persist this field to the database
    @Transient
    private Customer customer;

    private Long customerId;

}
