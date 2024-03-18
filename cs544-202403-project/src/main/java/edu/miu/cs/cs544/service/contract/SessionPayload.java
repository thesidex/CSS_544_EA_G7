package edu.miu.cs.cs544.service.contract;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class SessionPayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDate date;
    private Long scheduleId;

}
