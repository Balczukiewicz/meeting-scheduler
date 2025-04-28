package org.example.meeting_scheduler.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MeetingEventListener {

    @Async
    @EventListener
    public void handleMeetingCreated(MeetingCreatedEvent event) {
        log.info("🆕 Meeting created with ID: {}", event.meetingId());
    }

    @Async
    @EventListener
    public void handleMeetingInitialized(MeetingInitializedEvent event) {
        log.info("🚀 Meeting initialized with ID: {}", event.meetingId());
    }

    @Async
    @EventListener
    public void handleMeetingRescheduled(MeetingRescheduledEvent event) {
        log.info("📅 Meeting rescheduled: ID={}, NewStart={}, NewEnd={}",
                event.meetingId(), event.newStartTime(), event.newEndTime());
    }

    @Async
    @EventListener
    public void handleMeetingCancelled(MeetingCancelledEvent event) {
        log.info("❌ Meeting cancelled with ID: {}", event.meetingId());
    }
}
