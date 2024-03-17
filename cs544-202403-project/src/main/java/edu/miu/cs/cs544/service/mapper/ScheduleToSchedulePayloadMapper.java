package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.service.contract.SchedulePayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
@Component
public class ScheduleToSchedulePayloadMapper extends BaseMapper<Schedule, SchedulePayload> {
    public ScheduleToSchedulePayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Schedule.class, SchedulePayload.class);
    }
}
