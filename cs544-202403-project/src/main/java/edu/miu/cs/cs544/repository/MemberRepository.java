package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepository extends BaseRepository<Member, Integer>{

    @Query("SELECT DISTINCT m.email FROM Member m JOIN m.accounts a WHERE a.balance < (a.defaultBalance * 0.05)")
    List<String> findMemberEmailsByLowBalance();

}
