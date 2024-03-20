package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.EventRegistrationId;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.domain.Registration;
import edu.miu.cs.cs544.domain.Session;
import edu.miu.cs.cs544.service.contract.RecordPayload;
import edu.miu.cs.cs544.service.contract.RecordRequestPayload;
import edu.miu.cs.cs544.service.contract.RegistrationPayload;

import java.util.List;

public interface RegistrationService extends BaseReadWriteService <RegistrationPayload, Registration, EventRegistrationId>{
    void registerEvent (Long memberId, Long eventId);
}
