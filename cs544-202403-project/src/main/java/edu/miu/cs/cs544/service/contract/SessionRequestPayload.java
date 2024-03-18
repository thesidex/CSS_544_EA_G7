package edu.miu.cs.cs544.service.contract;

import lombok.Data;
import java.time.LocalDate;

@Data
public class SessionRequestPayload {
   private LocalDate date;
   private Long scheduleId;
}
