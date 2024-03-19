package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Location;
import edu.miu.cs.cs544.domain.Scanner;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class RecordPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDateTime scanTime;
	private Long scannerId;
}
