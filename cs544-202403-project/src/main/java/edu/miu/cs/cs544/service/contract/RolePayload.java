package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Member;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class RolePayload implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Long id;
    private String roleName;
    private Set<Account> accounts;
}
