package edu.miu.cs.cs544.repository;


import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {


}
