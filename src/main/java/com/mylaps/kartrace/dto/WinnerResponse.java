package com.mylaps.kartrace.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public record WinnerResponse(
        boolean isRaceFinished,
        Integer kartNumber,
        Integer lapNumber,
        Duration lapDuration,
        LocalDateTime lapStartTime,
        LocalDateTime lapCompleteTime
) {
}

