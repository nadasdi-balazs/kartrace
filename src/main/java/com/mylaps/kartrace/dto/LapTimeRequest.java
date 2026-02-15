package com.mylaps.kartrace.dto;

import java.time.LocalDateTime;

public record LapTimeRequest(
        int kartNumber,
        LocalDateTime timestamp
) {
}

