package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.Schedule;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends BaseRepository<Schedule, Long> {
}
