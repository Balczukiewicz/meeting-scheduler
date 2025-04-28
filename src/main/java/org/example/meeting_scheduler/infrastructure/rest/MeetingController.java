package org.example.meeting_scheduler.infrastructure.rest;

import org.example.meeting_scheduler.application.MeetingApplicationService;
import org.example.meeting_scheduler.dto.CreateMeetingRequestDto;
import org.example.meeting_scheduler.dto.MeetingResponseDto;
import org.example.meeting_scheduler.dto.RescheduleMeetingRequestDto;
import org.example.meeting_scheduler.infrastructure.persistence.MeetingDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class MeetingController implements MeetingApi {

    private final MeetingApplicationService meetingApplicationService;
    private final MeetingDtoMapper meetingDtoMapper;

    public MeetingController(MeetingApplicationService meetingApplicationService, MeetingDtoMapper meetingDtoMapper) {
        this.meetingApplicationService = meetingApplicationService;
        this.meetingDtoMapper = meetingDtoMapper;
    }

    @Override
    public ResponseEntity<MeetingResponseDto> getMeeting(UUID id) {
        return meetingApplicationService.findById(id)
                .map(meetingDtoMapper::toMeetingResponseDto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Meeting not found"));
    }

    @Override
    public ResponseEntity<MeetingResponseDto> createMeeting(CreateMeetingRequestDto request) {
        MeetingResponseDto response = meetingApplicationService.createMeeting(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<MeetingResponseDto> rescheduleMeeting(UUID id, RescheduleMeetingRequestDto request) {
        MeetingResponseDto response = meetingApplicationService.rescheduleMeeting(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> cancelMeeting(UUID id) {
        meetingApplicationService.cancelMeeting(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<MeetingResponseDto> initializeMeeting(UUID id) {
        MeetingResponseDto response = meetingApplicationService.initializeMeeting(id);
        return ResponseEntity.ok(response);
    }

}
