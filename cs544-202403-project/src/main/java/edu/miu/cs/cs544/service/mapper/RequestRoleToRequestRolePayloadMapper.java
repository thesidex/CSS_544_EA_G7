package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.service.contract.RequestRolePayload;
import edu.miu.cs.cs544.service.contract.RolePayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestRoleToRequestRolePayloadMapper extends BaseMapper<Role, RequestRolePayload> {

    public RequestRoleToRequestRolePayloadMapper(MapperFactory mapperFactory){
        super(mapperFactory, Role.class, RequestRolePayload.class);
    }

}
