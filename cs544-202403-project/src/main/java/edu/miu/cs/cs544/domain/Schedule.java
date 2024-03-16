package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime startTime;
    private LocalTime endTime;
    private String weekDays;
    private String scheduleName;

    @OneToMany(mappedBy = "schedule")
    private Set<Session> sessions;

    @OneToOne(mappedBy = "schedule")
    private Event event;

    public Schedule() {}

    public Schedule(LocalTime startTime, LocalTime endTime, String weekDays, String scheduleName, Set<Session> sessions, Event event) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDays = weekDays;
        this.scheduleName = scheduleName;
        this.sessions = sessions;
        this.event = event;
    }
}
