package edu.miu.cs.cs544.service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AccountPayload;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {

        @Autowired
        AttendanceRepository attendanceRepository;

        public List<AttendancePayload> getAttendanceByAccountIdAndStartTimeAndEndTime(Long accountId, String startTime,
                        String endTime) {

                List<Attendance> attendanceList = attendanceRepository.findAllByAccountId(accountId, startTime,
                                endTime);
                List<AttendancePayload> attendancePayloadList = new ArrayList<AttendancePayload>();
                attendanceList.stream().forEach(a -> {
                        AttendancePayload ap = new AttendancePayload();
                        ap.setMember(a.getMember());
                        ap.setScanner(a.getScanner());
                        attendancePayloadList.add(ap);
                });

                return attendancePayloadList;
        }
}
