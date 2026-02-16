package com.mylaps.kartrace.service;

import com.mylaps.kartrace.domain.CompletedLap;
import com.mylaps.kartrace.domain.Kart;
import com.mylaps.kartrace.dto.CompleteLapForKartRequest;
import com.mylaps.kartrace.dto.RaceResponse;
import com.mylaps.kartrace.dto.StartRaceRequest;
import com.mylaps.kartrace.dto.WinnerResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RaceService {
    private int totalLaps;
    private LocalDateTime startedAt;
    private Map<Integer, Kart> kartsInRace;

    public RaceResponse startRace(StartRaceRequest request) {
        this.startedAt = LocalDateTime.now();
        this.kartsInRace = request.kartNumbers().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        kartNumber -> new Kart(kartNumber, startedAt)
                ));
        this.totalLaps = request.totalLaps();

        return new RaceResponse(
                totalLaps,
                startedAt,
                null
        );
    }

    public WinnerResponse getWinner() {
        boolean isRaceFinished = isRaceFinished();
        if (!isRaceFinished) {
            return new WinnerResponse(
                    false,
                    null,
                    null,
                    null,
                    null,
                    null
            );
        }
        Map<Kart, CompletedLap> bestLapOfEachKart = kartsInRace.values().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        Kart::calculateBestLap
                ));
        CompletedLap winnerLap = null;
        Kart winnerKart = null;
        Set<Map.Entry<Kart, CompletedLap>> entries = bestLapOfEachKart.entrySet();
        for (Map.Entry<Kart, CompletedLap> bestLapOfAKartEntry : entries) {
            CompletedLap bestLapOfAKart = bestLapOfAKartEntry.getValue();
            if (winnerLap == null) {
                winnerLap = bestLapOfAKart;
                winnerKart = bestLapOfAKartEntry.getKey();
                continue;
            }
            Duration bestDurationOfKart = bestLapOfAKart.duration();
            Duration winnerDuration = winnerLap.duration();
            //if this kart's best lap's duration is smaller than the current best lap duration
            if (bestDurationOfKart.compareTo(winnerDuration) < 0) {
                winnerLap = bestLapOfAKart;
                winnerKart = bestLapOfAKartEntry.getKey();
            }
        }
        return new WinnerResponse(
                true,
                winnerKart.getKartNumber(),
                winnerLap.lapNumber(),
                winnerLap.duration(),
                winnerLap.started(),
                winnerLap.completed()
        );
    }

    private boolean isRaceFinished() {
        return kartsInRace.values().stream()
                .anyMatch(kart -> kart.calculateNumberOfCompletedLaps() >= totalLaps);
    }

    public void recordLapTime(CompleteLapForKartRequest request) {
        int kartNumber = request.kartNumber();
        Kart kart = kartsInRace.get(kartNumber);
        kart.completeLap(request.completedAt());
    }
}
