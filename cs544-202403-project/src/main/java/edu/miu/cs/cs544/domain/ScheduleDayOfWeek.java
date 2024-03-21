package edu.miu.cs.cs544.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.DayOfWeek;

@Entity
@Data
public class ScheduleDayOfWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    @JsonIgnore
    private Schedule schedule;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    public ScheduleDayOfWeek() {}
}
