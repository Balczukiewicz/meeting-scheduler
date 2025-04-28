package org.example.meeting_scheduler.event;

import java.util.UUID;

public record MeetingCreatedEvent(UUID meetingId) {
}
