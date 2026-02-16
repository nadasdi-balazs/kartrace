package com.mylaps.kartrace.dto;

import java.time.LocalDateTime;

public record CompleteLapForKartRequest(
        int kartNumber,
        LocalDateTime completedAt
) {
}

