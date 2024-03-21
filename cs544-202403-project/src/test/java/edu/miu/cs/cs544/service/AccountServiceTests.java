package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.repository.AttendanceRepository;
import edu.miu.cs.cs544.service.contract.AttendancePayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountServiceTests {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AttendanceRepository attendanceRepository;

    @InjectMocks // This will inject the mocked repositories into the actual AccountService
    private AccountService accountService;

    // Example setup, replace with your actual setup
    private List<Attendance> attendances = new ArrayList<>();

    @BeforeEach
    public void setup() {
        // Initialize your mock data here
        Attendance attendance = new Attendance();
        attendances.add(attendance);

        // Example: Preparing mock behavior
        // Assuming getAttendanceByAccountIdAndStartTimeAndEndTime is a method in AccountService
        // You'll need to adjust this to fit your actual method's return type and parameters
        Long accountId = 1L;
        String startTime = "2023-01-01";
        String endTime = "2023-01-31";
        List<AttendancePayload> mockPayload = List.of(new AttendancePayload()); // Adjust constructor as necessary

        given(accountService.getAttendanceByAccountIdAndStartTimeAndEndTime(accountId, startTime, endTime)).willReturn(mockPayload);
    }

    @Test
    public void getAttendance_NonEmptyList_ShouldReturnExpectedPayload() {
        // Arrange
        Long accountId = 1L;
        String startTime = "2023-01-01";
        String endTime = "2023-01-31";

        // Act
        List<AttendancePayload> result = accountService.getAttendanceByAccountIdAndStartTimeAndEndTime(accountId, startTime, endTime);

        // Assert
        assertThat(result).isNotEmpty(); // You can add more specific checks here depending on what you expect in the payload
    }

    @Test
    public void getAttendance_EmptyList_ShouldReturnEmptyPayload() {
        // Arrange - modify the setup to return an empty list for this scenario
        Long accountId = 2L; // Assume this accountId has no attendances
        String startTime = "2023-02-01";
        String endTime = "2023-02-28";
        given(accountService.getAttendanceByAccountIdAndStartTimeAndEndTime(accountId, startTime, endTime)).willReturn(new ArrayList<>());

        // Act
        List<AttendancePayload> result = accountService.getAttendanceByAccountIdAndStartTimeAndEndTime(accountId, startTime, endTime);

        // Assert
        assertThat(result).isEmpty();
    }
}