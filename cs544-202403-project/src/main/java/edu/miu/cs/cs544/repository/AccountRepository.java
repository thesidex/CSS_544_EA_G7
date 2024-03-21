package edu.miu.cs.cs544.repository;


import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
    @Query(value = "select m.email from Account a, Member m where a.member_id = m.id and cvalue < dvalue*0.05", nativeQuery = true)
    List<String> findAccountsByBalanceCondition();
}
