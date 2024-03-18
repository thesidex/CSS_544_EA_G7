package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Setter;

@Entity
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Schedule schedule;

    @Setter
    private LocalDate date;

    public Session() {}

    public Session(Schedule schedule, LocalDate date) {
        this.schedule = schedule;
        this.date = date;
    }
    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ","  +
                ", date=" + date +
                '}';
    }
    public Long getId() {
        return id;
    }
    public Schedule getSchedule() {
        return schedule;
    }

    public LocalDate getDate() {
        return date;
    }


}
