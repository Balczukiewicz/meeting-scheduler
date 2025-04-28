package org.example.meeting_scheduler.event;

import org.example.meeting_scheduler.domain.Meeting;

import java.time.LocalDateTime;
import java.util.UUID;

public interface MeetingEventPublisher {

    Meeting create(String title, LocalDateTime startTime, LocalDateTime endTime);
    void initialized(UUID meetingId);

    void rescheduled(UUID meetingId, LocalDateTime newStartTime, LocalDateTime newEndTime);

    void cancelled(UUID meetingId);
}
