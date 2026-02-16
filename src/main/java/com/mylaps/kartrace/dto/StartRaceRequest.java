package com.mylaps.kartrace.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * A race is not a race if there is only one kart racing, the minimal number is 2.
 * It can have a maximum of 5 participants as per specification.
 */
public record StartRaceRequest(
        @NotNull @Size(min = 2, max = 5)
        List<Integer> kartNumbers,
        int totalLaps
) {
}
