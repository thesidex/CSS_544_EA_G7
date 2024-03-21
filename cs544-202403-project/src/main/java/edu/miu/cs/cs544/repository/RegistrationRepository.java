package edu.miu.cs.cs544.repository;

import edu.miu.common.repository.BaseRepository;
import edu.miu.cs.cs544.domain.EventRegistrationId;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Registration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends BaseRepository<Registration, EventRegistrationId> {
}
