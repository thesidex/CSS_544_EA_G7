package edu.miu.cs.cs544.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@Embeddable
public class EventRegistrationId implements Serializable {
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "event_id")
    private Long eventId;

    public EventRegistrationId(Long memberId, Long eventId) {
        this.memberId = memberId;
        this.eventId = eventId;
    }

    public EventRegistrationId() {}

}
