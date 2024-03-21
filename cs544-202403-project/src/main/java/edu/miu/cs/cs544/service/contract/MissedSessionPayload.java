package edu.miu.cs.cs544.service.contract;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MissedSessionPayload {
    private List<SessionInfo> missedSessions;
    private int totalSessionsPresent;
    private int totalSessionsAttended;

    @Data
    public static class SessionInfo {
        private Long sessionId;
        private LocalDateTime timing;
    }
}
