package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.SessionPayload;
import edu.miu.cs.cs544.service.contract.SessionRequestPayload;

import java.util.List;

public interface SessionService extends BaseReadWriteService<SessionPayload, Session, Long> {
    List<SessionPayload> getSessionsByEventId(Long eventId);
    SessionPayload addSessionToEvent(Long eventId, SessionRequestPayload sessionRequestPayload);
    void deleteSession(Long eventId, Long sessionId);
    SessionPayload updateSession(Long eventId, Long sessionId, SessionRequestPayload sessionRequestPayload);
}
