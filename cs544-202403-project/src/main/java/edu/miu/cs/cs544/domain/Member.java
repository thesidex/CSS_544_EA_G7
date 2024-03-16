package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MemberID")
	private Integer memberId;
	
	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Barcode")
	private String barcode;

    @Column(name = "Email")
    private String email;

	/*One member can have multiple roles*/

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
