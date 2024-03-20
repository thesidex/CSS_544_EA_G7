package edu.miu.cs.cs544.service;


import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import org.springframework.stereotype.Component;

@Component
public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Long> {



}
