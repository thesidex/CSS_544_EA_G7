package edu.miu.cs.cs544.service.contract;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RecordPayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDateTime scanTime;
}
