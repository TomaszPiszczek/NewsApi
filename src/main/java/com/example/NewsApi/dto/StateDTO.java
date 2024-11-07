package com.example.NewsApi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class StateDTO {
    private UUID id;
    private String stateName;
}
