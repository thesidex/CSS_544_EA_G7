package edu.miu.cs.cs544.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Registration implements Serializable {

    @EmbeddedId
    private EventRegistrationId id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    Member member;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    Event event;

    public Registration(){};

    public Registration(Member member, Event event) {
        this.member = member;
        this.event = event;
    }
}
