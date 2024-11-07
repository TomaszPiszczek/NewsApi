package com.example.NewsApi.mapper;

import com.example.NewsApi.dto.CityDTO;
import com.example.NewsApi.model.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    public CityDTO toDto(City city) {
        CityDTO dto = new CityDTO();
        dto.setId(city.getId());
        dto.setCityName(city.getCityName());
        dto.setStateId(city.getState().getId());
        return dto;
    }

    public City toEntity(CityDTO dto) {
        City city = new City();
        city.setId(dto.getId());
        city.setCityName(dto.getCityName());
        return city;
    }
}
