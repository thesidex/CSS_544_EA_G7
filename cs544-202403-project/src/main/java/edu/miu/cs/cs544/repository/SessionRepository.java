package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends BaseRepository<Session, Long> {
    @Query("SELECT s FROM Session s WHERE s.schedule.event.id = :eventId")
    List<Session> findByEventId(@Param("eventId") Long eventId);
}
