package org.example.meeting_scheduler.infrastructure.persistence;

import org.example.meeting_scheduler.domain.Meeting;
import org.example.meeting_scheduler.dto.MeetingResponseDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MeetingDtoMapper {
    MeetingResponseDto toMeetingResponseDto(Meeting meeting);

}
