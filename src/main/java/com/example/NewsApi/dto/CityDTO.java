package com.example.NewsApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CityDTO {
    private UUID id;
    private String cityName;
    private UUID stateId;
}
