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

    //One-Many roles can have One-Many members
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

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
