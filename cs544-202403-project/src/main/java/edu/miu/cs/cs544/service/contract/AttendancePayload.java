package edu.miu.cs.cs544.service.contract;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Scanner;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AttendancePayload implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Member member;
    private Scanner scanner;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public AttendancePayload(Member member, Scanner scanner, LocalDateTime dateTime) {
        this.member = member;
        this.scanner = scanner;
        this.dateTime = dateTime;
    }

    public AttendancePayload() {
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    private LocalDateTime dateTime;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
