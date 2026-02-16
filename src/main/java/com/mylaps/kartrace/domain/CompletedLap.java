package com.mylaps.kartrace.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public record CompletedLap(int lapNumber, LocalDateTime started, LocalDateTime completed) {
    public Duration duration() {
        return Duration.between(started, completed);
    }
}
