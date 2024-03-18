package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_Id")
    private Long id;

    @Column(name = "role_Name")
    private String roleName;

    @ManyToMany
    private Set<Account> accounts;

    public Role() {}

    public Role(String roleName, Set<Account> accounts) {
        this.roleName = roleName;
        this.accounts = accounts;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
