package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends BaseRepository<Record, Long> {
    @Query("SELECT r FROM Record r JOIN r.scanner s JOIN Event e WHERE e.id = :eventId AND r.member.id = :memberId")
    List<Record> getMemberEventAttendance(@Param("memberId") Long memberId, @Param("eventId") Long eventId);

    List<Record> findByScannerId(Long scannerId);
}
