package org.example.meeting_scheduler.application.exception;

import java.util.UUID;

public class MeetingNotFoundException extends RuntimeException {
    public MeetingNotFoundException(UUID id) {
        super("Meeting with id " + id + " not found.");
    }
}
