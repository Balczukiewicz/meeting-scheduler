package org.example.meeting_scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RescheduleMeetingRequestDto {
    private LocalDateTime newStartTime;
    private LocalDateTime newEndTime;
}
