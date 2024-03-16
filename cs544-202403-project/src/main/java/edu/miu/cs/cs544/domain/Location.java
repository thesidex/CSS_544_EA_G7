package edu.miu.cs.cs544.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private LocationType locationType;

    public Location() {}

    public Location(String name, String description, LocationType locationType) {
        this.name = name;
        this.description = description;
        this.locationType = locationType;
    }
}
