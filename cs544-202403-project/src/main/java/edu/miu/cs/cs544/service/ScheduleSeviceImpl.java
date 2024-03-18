package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.service.contract.SchedulePayload;
import org.springframework.stereotype.Service;

@Service
public class ScheduleSeviceImpl extends BaseReadWriteServiceImpl<SchedulePayload, Schedule, Long> implements ScheduleService{
}
