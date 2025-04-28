package org.example.meeting_scheduler.dto;


import lombok.*;
import org.example.meeting_scheduler.domain.Status;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MeetingResponseDto {
    private UUID id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private LocalDateTime initializedAt;
}
