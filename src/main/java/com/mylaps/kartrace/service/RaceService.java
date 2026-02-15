package com.mylaps.kartrace.service;

import com.mylaps.kartrace.dto.LapTimeRequest;
import com.mylaps.kartrace.dto.RaceResponse;
import com.mylaps.kartrace.dto.StartRaceRequest;
import com.mylaps.kartrace.dto.WinnerResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RaceService {
    private UUID raceId;

    public RaceResponse startRace(StartRaceRequest request) {
        //TODO: implement business logic
        UUID raceId = UUID.randomUUID();
        this.raceId = raceId;
        int totalLaps = 1;
        return new RaceResponse(
                raceId,
                "STARTED",
                totalLaps,
                LocalDateTime.now(),
                null
        );
    }

    public RaceResponse finishRace(UUID raceId) {
        String status = "";
        int totalLaps = 1;
        LocalDateTime startedAt = null;
        LocalDateTime finishedAt = null;
        return new RaceResponse(raceId, status, totalLaps, startedAt, finishedAt);
    }

    public WinnerResponse getWinner(UUID raceId) {
        int kartNumber = 0;
        int lapNumber = 0;
        Duration lapDuration = null;
        LocalDateTime lapStartTime = null;
        return new WinnerResponse(kartNumber, lapNumber, lapDuration, lapStartTime);
    }

    public void recordLapTime(UUID raceId, LapTimeRequest request) {
    }
}
