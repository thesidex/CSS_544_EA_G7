package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Long> {



}
