package com.mylaps.kartrace.domain;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Kart {
    @Getter
    private final int kartNumber;
    /**
     * This list works as follows:
     * The first entry is the start timestamp of the first lap. In this case, the first lap is started,
     * but not completed, the number of completed laps should calculate to 0.
     * The second entry refers to the complete timestamp of the first lap. It is also the beginning timestamp
     * of the second lap, for that matter. The number of completed laps is 1.
     * And so on ... :)
     */
    private final List<LocalDateTime> lapsCompleted = new ArrayList<>();

    public Kart(int kartNumber, LocalDateTime startedAt) {
        this.kartNumber = kartNumber;
        lapsCompleted.add(startedAt);
    }

    public void completeLap(LocalDateTime completedAt) {
        lapsCompleted.add(completedAt);
    }

    public int calculateNumberOfCompletedLaps() {
        return lapsCompleted.size() - 1;
    }

    //TODO: write unit test for this
    public List<CompletedLap> calculateLapDurations() {
        List<CompletedLap> laps = new ArrayList<>();
        for (int lapNumber = 1; lapNumber < lapsCompleted.size(); lapNumber++) {
            LocalDateTime started = lapsCompleted.get(lapNumber - 1);
            LocalDateTime completed = lapsCompleted.get(lapNumber);
            CompletedLap lap = new CompletedLap(lapNumber, started, completed);
            laps.add(lap);
        }
        return laps;
    }

    //TODO: write unit test for this
    public CompletedLap calculateBestLap() {
        return calculateLapDurations().stream()
                .min((lapOne, lapOther) -> {
                    Duration durationOne = lapOne.duration();
                    Duration durationOther = lapOther.duration();
                    return durationOne.compareTo(durationOther);
                })
                .orElseThrow();
    }
}
