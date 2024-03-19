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

//    @OneToMany
//    @JoinColumn(name = "member_id")
//    private Set<Member> members;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scanner_id")
    private Scanner scanner;
    
    public Record() {
    }

    public Long getId() {
        return id;
    }

    public Record(LocalDateTime scanTime, Scanner scanner) {
        this.scanTime = scanTime;
//        this.members = members;
        this.scanner = scanner;
    }
}