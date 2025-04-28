package org.example.meeting_scheduler.event;

import lombok.RequiredArgsConstructor;
import org.example.meeting_scheduler.domain.Meeting;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SpringMeetingEventPublisher implements MeetingEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public Meeting create(String title, LocalDateTime startTime, LocalDateTime endTime) {

        Meeting meeting = new Meeting(title, startTime, endTime);
        eventPublisher.publishEvent(new MeetingInitializedEvent(meeting.getId()));
        return meeting;
    }

    @Override
    public void initialized(UUID meetingId) {
        eventPublisher.publishEvent(new MeetingInitializedEvent(meetingId));
    }

    @Override
    public void rescheduled(UUID meetingId, LocalDateTime newStartTime, LocalDateTime newEndTime) {
        eventPublisher.publishEvent(new MeetingRescheduledEvent(meetingId, newStartTime, newEndTime));
    }

    @Override
    public void cancelled(UUID meetingId) {
        eventPublisher.publishEvent(new MeetingCancelledEvent(meetingId));
    }
}
