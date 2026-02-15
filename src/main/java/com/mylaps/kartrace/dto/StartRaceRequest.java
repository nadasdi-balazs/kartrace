package com.mylaps.kartrace.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record StartRaceRequest(
        @NotNull @Size(min = 1, max = 5)
        List<Integer> kartNumbers,
        int totalLaps
) {
}
