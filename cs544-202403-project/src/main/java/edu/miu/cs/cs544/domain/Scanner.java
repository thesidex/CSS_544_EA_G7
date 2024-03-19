package edu.miu.cs.cs544.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Scanner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Column(name = "location")
    private Location location;

//    @ManyToMany
//    private Set<Location> locations;

    @OneToMany
    @JoinColumn(name = "scanner_id")
    private List<Event> events;

    @OneToMany(mappedBy = "scanner")
    private List<Record> records;

    public Scanner() {}

    public Scanner(Location location, List<Event> events, List<Record> records) {
        this.location = location;
        this.events = events;
        this.records = records;
    }
}
