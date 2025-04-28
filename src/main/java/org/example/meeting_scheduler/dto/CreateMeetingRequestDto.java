package org.example.meeting_scheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.meeting_scheduler.domain.Status;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CreateMeetingRequestDto {

    @NotBlank
    private String title;
    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    private Status status;
    private LocalDateTime initializedAt;
}
