package com.example.NewsApi.service;

import com.example.NewsApi.dto.CityDTO;
import com.example.NewsApi.mapper.CityMapper;
import com.example.NewsApi.repository.CityRepository;
import com.example.NewsApi.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.NewsApi.dto.StateDTO;
import com.example.NewsApi.mapper.StateMapper;

@Service
public class CityStateService {

    private final StateRepository stateRepository;
    private final StateMapper stateMapper;
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityStateService(StateRepository stateRepository, StateMapper stateMapper, CityRepository cityRepository, CityMapper cityMapper) {
        this.stateRepository = stateRepository;
        this.stateMapper = stateMapper;
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    public List<StateDTO> getAllStates() {
        return stateRepository.findAll().stream()
                .map(stateMapper::toDto)
                .sorted((state1, state2) -> state1.getStateName().compareToIgnoreCase(state2.getStateName()))
                .collect(Collectors.toList());
    }
    public List<CityDTO> getAllCities() {
        return cityRepository.findAll().stream()
                .map(cityMapper::toDto)
                .sorted((city1, city2) -> city1.getCityName().compareToIgnoreCase(city2.getCityName()))
                .collect(Collectors.toList());
    }

    public List<CityDTO> getCitiesByState(UUID stateId) {
        return cityRepository.findByState_Id(stateId).stream()
                .map(cityMapper::toDto)
                .sorted((city1, city2) -> city1.getCityName().compareToIgnoreCase(city2.getCityName()))
                .collect(Collectors.toList());
    }
}
