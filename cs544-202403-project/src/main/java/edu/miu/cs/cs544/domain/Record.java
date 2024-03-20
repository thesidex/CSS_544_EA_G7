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
    private Long id;

    @Column(name = "scan_time")
    private LocalDateTime scanTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;
    private long session_id;
    
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
    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", scanTime=" + scanTime +
                '}';
    }
}