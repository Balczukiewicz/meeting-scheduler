package org.example.meeting_scheduler.infrastructure.rest;

import jakarta.validation.Valid;
import org.example.meeting_scheduler.dto.CreateMeetingRequestDto;
import org.example.meeting_scheduler.dto.MeetingResponseDto;
import org.example.meeting_scheduler.dto.RescheduleMeetingRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/meetings")
public interface MeetingApi {

    @GetMapping("/{id}")
    ResponseEntity<MeetingResponseDto> getMeeting(@PathVariable UUID id);

    @PostMapping
    ResponseEntity<MeetingResponseDto> createMeeting(@Valid @RequestBody CreateMeetingRequestDto request);

    @PutMapping("/{id}/reschedule")
    ResponseEntity<MeetingResponseDto> rescheduleMeeting(@PathVariable UUID id, @Valid @RequestBody RescheduleMeetingRequestDto request);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> cancelMeeting(@PathVariable UUID id);

    @PutMapping("/{id}/initialize")
    ResponseEntity<MeetingResponseDto> initializeMeeting(@PathVariable UUID id);

}
