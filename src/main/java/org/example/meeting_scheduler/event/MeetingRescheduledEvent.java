package org.example.meeting_scheduler.event;

import java.time.LocalDateTime;
import java.util.UUID;

public record MeetingRescheduledEvent(UUID meetingId, LocalDateTime newStartTime, LocalDateTime newEndTime) {
}
