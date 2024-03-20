package edu.miu.cs.cs544.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.time.DayOfWeek;

@Entity
@Data
public class ScheduleDayOfWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    public ScheduleDayOfWeek() {}
}
