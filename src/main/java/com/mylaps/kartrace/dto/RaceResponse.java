package com.mylaps.kartrace.dto;

import java.time.LocalDateTime;

public record RaceResponse(
        int totalLaps,
        LocalDateTime startedAt,
        LocalDateTime finishedAt
) {
}

