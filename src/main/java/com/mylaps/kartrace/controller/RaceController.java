package com.mylaps.kartrace.controller;

import com.mylaps.kartrace.dto.LapTimeRequest;
import com.mylaps.kartrace.dto.RaceResponse;
import com.mylaps.kartrace.dto.StartRaceRequest;
import com.mylaps.kartrace.dto.WinnerResponse;
import com.mylaps.kartrace.service.RaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/races")
@RequiredArgsConstructor
public class RaceController {

    private final RaceService raceService;

    @PostMapping("/start")
    public ResponseEntity<RaceResponse> startRace(@Valid @RequestBody StartRaceRequest request) {
        RaceResponse race = raceService.startRace(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(race);
    }

    @PostMapping("/{raceId}/finish")
    public ResponseEntity<RaceResponse> finishRace(@PathVariable UUID raceId) {
        RaceResponse race = raceService.finishRace(raceId);
        return ResponseEntity.ok(race);
    }

    @GetMapping("/{raceId}/winner")
    public ResponseEntity<WinnerResponse> getWinner(@PathVariable UUID raceId) {
        WinnerResponse winner = raceService.getWinner(raceId);
        return ResponseEntity.ok(winner);
    }

    @PostMapping("/{raceId}/lap-times")
    public ResponseEntity<Void> recordLapTime(
            @PathVariable UUID raceId,
            @RequestBody LapTimeRequest request) {
        raceService.recordLapTime(raceId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

