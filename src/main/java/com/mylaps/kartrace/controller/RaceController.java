package com.mylaps.kartrace.controller;

import com.mylaps.kartrace.dto.CompleteLapForKartRequest;
import com.mylaps.kartrace.dto.RaceResponse;
import com.mylaps.kartrace.dto.StartRaceRequest;
import com.mylaps.kartrace.dto.WinnerResponse;
import com.mylaps.kartrace.service.RaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/winner")
    public ResponseEntity<WinnerResponse> getWinner() {
        WinnerResponse winner = raceService.getWinner();
        return ResponseEntity.ok(winner);
    }

    @PostMapping("/lap-times")
    public ResponseEntity<Void> recordLapTime(
            @RequestBody CompleteLapForKartRequest request) {
        raceService.recordLapTime(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

