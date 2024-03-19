package edu.miu.cs.cs544.service.contract;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import edu.miu.cs.cs544.domain.Event;
import edu.miu.cs.cs544.domain.Location;
import lombok.Data;

@Data
public class ScannerPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String location;
	private List<Event> events;
    private Set<Record> records;
}
