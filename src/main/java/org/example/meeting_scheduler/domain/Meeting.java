package org.example.meeting_scheduler.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meeting {
    @Id
    private UUID id = UUID.randomUUID();
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private LocalDateTime initializedAt;

    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = Status.NEW;
    }

    public void initialize() {
        if (status != Status.NEW) {
            throw new IllegalStateException("Only NEW meetings can be initialized.");
        }
        this.status = Status.INITIALIZED;
        this.initializedAt = LocalDateTime.now();
    }

    public void cancel() {
        if (status == Status.CANCELLED) {
            throw new IllegalStateException("Meeting is already cancelled.");
        }
        this.status = Status.CANCELLED;
    }

    public void reschedule(LocalDateTime newStart, LocalDateTime newEnd) {
        if (status == Status.CANCELLED) {
            throw new IllegalStateException("Cancelled meetings cannot be rescheduled.");
        }
        this.startTime = newStart;
        this.endTime = newEnd;
        this.status = Status.RESCHEDULED;
    }
}
