package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findLocationById(Long locationId);

}
