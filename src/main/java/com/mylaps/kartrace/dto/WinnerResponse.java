package com.mylaps.kartrace.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public record WinnerResponse(
        int kartNumber,
        int lapNumber,
        Duration lapDuration,
        LocalDateTime lapStartTime
) {
}

