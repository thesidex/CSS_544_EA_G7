package edu.miu.cs.cs544.service.mapper;

import edu.miu.common.service.mapper.BaseMapper;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.RolePayload;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleToRolePayloadMapper extends BaseMapper<Role, RolePayload> {

    public RoleToRolePayloadMapper(MapperFactory mapperFactory){
        super(mapperFactory, Role.class, RolePayload.class);
    }

    public RolePayload customMapping(Role source) {
        RolePayload target = new RolePayload();
        target.setId(source.getId());
        target.setRoleName(source.getRoleName());
        target.setAccounts(source.getAccounts());
        return target;
    }

}
