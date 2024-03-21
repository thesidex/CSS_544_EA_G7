package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.service.contract.RequestRolePayload;
import edu.miu.cs.cs544.service.contract.RolePayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestRolePayloadToRequestRoleMapper extends BaseMapper<RequestRolePayload, Role> {

    public RequestRolePayloadToRequestRoleMapper(MapperFactory mapperFactory) {
        super(mapperFactory, RequestRolePayload.class, Role.class);
    }
}
