package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "scan_time")
    private LocalDateTime scanTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Record() {
    }

    public Long getId() {
        return id;
    }

    public Record(Member member, Scanner scanner, Session session) {
        this.scanTime = LocalDateTime.now();
        this.member = member;
        this.scanner = scanner;
        this.session = session;
    }
}