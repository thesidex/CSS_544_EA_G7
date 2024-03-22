package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @JoinColumn(name = "record_id")
    private Long id;

    @Column(name = "scan_time")
    @Setter
    private LocalDateTime scanTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
    
    public Record() {
    }

    public Record(Member member, Scanner scanner, Session session ) {
        this.scanTime = LocalDateTime.now();
        this.member = member;
        this.scanner = scanner;
        this.session = session;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ",scannerId="+scanner.getId()+
                ", scanTime=" + scanTime +
                '}';
    }
}