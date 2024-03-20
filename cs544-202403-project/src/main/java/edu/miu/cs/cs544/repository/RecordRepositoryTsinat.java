package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Scanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepositoryTsinat extends BaseRepository<Record, Long> {

    @Query("SELECT r FROM Record r WHERE r.scanner.event.id = :eventId")
    List<Record> findByScannerEventId(@Param("eventId") Long eventId);

}
