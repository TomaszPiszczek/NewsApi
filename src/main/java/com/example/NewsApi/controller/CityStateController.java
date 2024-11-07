package com.example.NewsApi.controller;

import com.example.NewsApi.dto.CityDTO;
import com.example.NewsApi.dto.StateDTO;
import com.example.NewsApi.service.CityStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CityStateController {

    private final CityStateService cityStateService;

    public CityStateController(CityStateService stateService) {
        this.cityStateService = stateService;
    }

    @GetMapping("/states")
    public ResponseEntity<List<StateDTO>> getAllStates() {
        List<StateDTO> states = cityStateService.getAllStates();
        return ResponseEntity.ok(states);
    }
    @GetMapping("/cities")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<CityDTO> cities = cityStateService.getAllCities();
        return ResponseEntity.ok(cities);
    }


    @GetMapping("/{stateId}/cities")
    public ResponseEntity<List<CityDTO>> getCitiesByState(@PathVariable UUID stateId) {
        List<CityDTO> cities = cityStateService.getCitiesByState(stateId);
        return ResponseEntity.ok(cities);
    }
}
