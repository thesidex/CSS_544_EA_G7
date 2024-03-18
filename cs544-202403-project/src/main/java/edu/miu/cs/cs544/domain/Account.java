package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String name; 
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    
    private BigDecimal balance;

    //One-Many accounts can have One-Many members
    @ManyToMany(mappedBy = "accounts")
    private Set<Member> members;

    @ManyToOne
    private Scanner scanner;
    public Account() {}

    public Account(String description, String name, AccountType accountType, BigDecimal balance, Set<Account> Accounts) {
        this.description = description;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.members = members;
    }
}
