package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Member;

import java.util.Optional;

public interface MemberRepository extends BaseRepository<Member, Long>{

    Optional<Member> findByBarcode(String barcode);
}
