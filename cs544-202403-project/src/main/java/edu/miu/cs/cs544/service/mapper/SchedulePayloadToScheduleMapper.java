package edu.miu.cs.cs544.service.mapper;


import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Schedule;
import edu.miu.cs.cs544.service.contract.SchedulePayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class SchedulePayloadToScheduleMapper extends BaseMapper<SchedulePayload, Schedule> {
    public SchedulePayloadToScheduleMapper(MapperFactory mapperFactory) {
        super(mapperFactory, SchedulePayload.class, Schedule.class);
    }
}
