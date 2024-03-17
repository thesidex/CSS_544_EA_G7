package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.service.contract.SchedulePayload;

public interface ScheduleService extends BaseReadWriteService<SchedulePayload, Schedule, Long> {
}
