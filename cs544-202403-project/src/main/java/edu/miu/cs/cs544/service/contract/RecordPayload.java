package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Member;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RecordPayload implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDateTime scanTime;
	private Member memberId;
	private Long scannerId;
}
