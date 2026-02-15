package com.mylaps.kartrace.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RaceResponse(
        UUID raceId,
        String status,
        int totalLaps,
        LocalDateTime startedAt,
        LocalDateTime finishedAt
) {
}

