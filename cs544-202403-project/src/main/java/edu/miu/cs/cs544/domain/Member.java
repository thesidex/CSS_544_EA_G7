package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String email;
    private String barcode;

    @ManyToMany
    private Set<Role> roles;

    @ManyToOne
    private Account account;

    @ManyToMany
    private Set<Event> events;

    public Member() {}

    public Member(String firstName, String lastName, String email, String barcode, Set<Role> roles, Account account, Set<Event> events) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.barcode = barcode;
        this.roles = roles;
        this.account = account;
        this.events = events;
    }
}
