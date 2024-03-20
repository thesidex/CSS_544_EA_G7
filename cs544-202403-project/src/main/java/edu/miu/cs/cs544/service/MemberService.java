package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteService;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{
    void takeAttendance(Long scannerId, ScanPayload scanPayload);
}
