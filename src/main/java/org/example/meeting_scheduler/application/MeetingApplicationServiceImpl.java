package org.example.meeting_scheduler.application;

import lombok.AllArgsConstructor;
import org.example.meeting_scheduler.application.exception.MeetingNotFoundException;
import org.example.meeting_scheduler.domain.Meeting;
import org.example.meeting_scheduler.domain.MeetingRepository;
import org.example.meeting_scheduler.dto.CreateMeetingRequestDto;
import org.example.meeting_scheduler.dto.MeetingResponseDto;
import org.example.meeting_scheduler.dto.RescheduleMeetingRequestDto;
import org.example.meeting_scheduler.event.MeetingEventPublisher;
import org.example.meeting_scheduler.infrastructure.persistence.MeetingDtoMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeetingApplicationServiceImpl implements MeetingApplicationService {

    private final MeetingRepository meetingRepository;
    private final MeetingDtoMapper meetingDtoMapper;
    private final MeetingEventPublisher eventPublisher;
    @Override
    public MeetingResponseDto createMeeting(CreateMeetingRequestDto requestDto) {
        Meeting meeting = eventPublisher.create(
                requestDto.getTitle(),
                requestDto.getStartTime(),
                requestDto.getEndTime()
        );
        meeting = meetingRepository.save(meeting);
        return meetingDtoMapper.toMeetingResponseDto(meeting);
    }

    @Override
    public Optional<Meeting> findById(UUID id) {
        return meetingRepository.findById(id);
    }

    @Override
    public MeetingResponseDto rescheduleMeeting(UUID id, RescheduleMeetingRequestDto rescheduleMeetingRequestDto) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new MeetingNotFoundException(id));
        meeting.reschedule(rescheduleMeetingRequestDto.getNewStartTime(), rescheduleMeetingRequestDto.getNewEndTime());
        meetingRepository.save(meeting);
        eventPublisher.rescheduled(meeting.getId(), rescheduleMeetingRequestDto.getNewStartTime(), rescheduleMeetingRequestDto.getNewEndTime());
        return meetingDtoMapper.toMeetingResponseDto(meeting);
    }

    @Override
    public MeetingResponseDto cancelMeeting(UUID id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new MeetingNotFoundException(id));
        meeting.cancel();
        meetingRepository.save(meeting);
        eventPublisher.cancelled(id);
        return meetingDtoMapper.toMeetingResponseDto(meeting);
    }

    public MeetingResponseDto initializeMeeting(UUID id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new MeetingNotFoundException(id));

        meeting.initialize();
        meetingRepository.save(meeting);
        eventPublisher.initialized(id);
        return meetingDtoMapper.toMeetingResponseDto(meeting);
    }

}
