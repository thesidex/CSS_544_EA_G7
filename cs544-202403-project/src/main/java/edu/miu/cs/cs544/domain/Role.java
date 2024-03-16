package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<Member> members;

    @ManyToMany
    private Set<Account> accounts;

    public Role() {}

    public Role(String roleName, Set<Member> members, Set<Account> accounts) {
        this.roleName = roleName;
        this.members = members;
        this.accounts = accounts;
    }
}
