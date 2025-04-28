package org.example.meeting_scheduler.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {

    @Override
    Optional<Meeting> findById(UUID uuid);
}
