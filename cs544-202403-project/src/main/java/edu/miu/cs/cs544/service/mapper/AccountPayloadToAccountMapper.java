package edu.miu.cs.cs544.service.mapper;


import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountPayloadToAccountMapper extends BaseMapper<AccountPayload, Account> {

    public AccountPayloadToAccountMapper(MapperFactory mapperFactory) {
        super(mapperFactory, AccountPayload.class, Account.class);


    }
}
