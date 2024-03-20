package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Scanner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @ManyToMany
    private Set<Location> locations;

    @OneToMany(mappedBy = "scanner")
    private Set<Record> records;


    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


    public Scanner() {}

    public Scanner(String location, Set<Location> locations, Set<Record> records) {
        this.location = location;
        this.locations = locations;
        this.records = records;
    }
}
