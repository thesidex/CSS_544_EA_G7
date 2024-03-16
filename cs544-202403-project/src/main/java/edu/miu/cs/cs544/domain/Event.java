package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @OneToOne
    private Schedule schedule;

    @OneToOne
    private Scanner scanner;

    @ManyToMany(mappedBy = "events")
    private Set<Member> members;

    public Event() {}

    public Event(String name, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, Schedule schedule, Scanner scanner, Set<Member> members) {
        this.name = name;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.schedule = schedule;
        this.scanner = scanner;
        this.members = members;
    }
}
