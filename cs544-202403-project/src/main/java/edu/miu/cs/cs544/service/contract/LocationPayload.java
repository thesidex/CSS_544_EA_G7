package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.LocationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.io.Serializable;

@Data

public class LocationPayload implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;

    private LocationType locationType;
}
