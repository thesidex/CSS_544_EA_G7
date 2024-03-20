package edu.miu.cs.cs544.service.contract;

import java.io.Serializable;
import edu.miu.cs.cs544.domain.Event;
import lombok.Data;

@Data
public class ScannerPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String locationId;
	private Event eventId;
}
