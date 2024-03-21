package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.RequestRolePayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import edu.miu.cs.cs544.domain.Role;
import java.util.List;




public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{
    void takeAttendance(Long scannerId, ScanPayload scanPayload);



    List<Role> getAllRoleForMember(Long memberId);
    Role getRoleForMember(Long memberId,Long roleId);
    void updateRole(Long memberId, RequestRolePayload requestRolePayload);
    Role createRole(Long memberId, Role role);

    void deleteRoleForMember(Long memberId,Long roleId);
}
