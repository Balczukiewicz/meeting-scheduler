package org.example.meeting_scheduler.application;

import org.example.meeting_scheduler.domain.Meeting;
import org.example.meeting_scheduler.dto.CreateMeetingRequestDto;
import org.example.meeting_scheduler.dto.MeetingResponseDto;
import org.example.meeting_scheduler.dto.RescheduleMeetingRequestDto;

import java.util.Optional;
import java.util.UUID;

public interface MeetingApplicationService {
    MeetingResponseDto createMeeting(CreateMeetingRequestDto requestDto);

    Optional<Meeting> findById(UUID id);

    MeetingResponseDto rescheduleMeeting(UUID id, RescheduleMeetingRequestDto rescheduleMeetingRequestDto);

    MeetingResponseDto cancelMeeting(UUID id);

    MeetingResponseDto initializeMeeting(UUID id);
}

