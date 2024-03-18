package edu.miu.cs.cs544.service.contract;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class MemberPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private String barcode;

	private String email;

	private List<Role> roles;

//	private List<Account> accounts;
//
//	private Set<Event> events;

}
