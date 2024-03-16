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

@Entity
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String name; 
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    
    private BigDecimal balance;

    @ManyToMany(mappedBy = "accounts")
    private Set<Role> roles;

    @ManyToOne
    private Member member;

    public Account() {}

    public Account(String description, String name, AccountType accountType, BigDecimal balance, Set<Role> roles, Member member) {
        this.description = description;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.roles = roles;
        this.member = member;
    }
}
