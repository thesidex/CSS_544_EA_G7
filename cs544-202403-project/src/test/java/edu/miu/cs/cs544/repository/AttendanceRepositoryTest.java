package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Attendance;
import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.AccountType;
import edu.miu.cs.cs544.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AttendanceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AttendanceRepository attendanceRepository;

    private Account account;
    private Member member;

    @BeforeEach
    void setUp() {
        member = new Member();
        entityManager.persist(member);

        account = new Account();
        account.setMember(member);
        entityManager.persist(account);

        Attendance attendance = new Attendance();
        attendance.setAccount(AccountType.DINING);
        attendance.setDateTime(LocalDateTime.now());
        entityManager.persist(attendance);
    }

    @Test
    void whenFindAllByAccountIdWithValidDates_thenShouldReturnAttendances() {
        String startDate = "2020-01-01";
        String endDate = "2025-12-31";

        List<Attendance> attendances = attendanceRepository.findAllByAccountId(account.getId(), startDate, endDate);

        assertThat(attendances).isNotEmpty();
        //assertThat(attendances.get(0).getAccount().getId()).isEqualTo(account.getId());
    }

    @Test
    void whenFindAllByAccountIdOutsideValidDates_thenShouldReturnEmpty() {
        String startDate = "1900-01-01";
        String endDate = "1901-01-01";

        List<Attendance> attendances = attendanceRepository.findAllByAccountId(account.getId(), startDate, endDate);

        assertThat(attendances).isEmpty();
    }
}
