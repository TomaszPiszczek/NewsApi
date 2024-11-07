package com.example.NewsApi.mapper;

import com.example.NewsApi.dto.StateDTO;
import com.example.NewsApi.model.State;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {
    public StateDTO toDto(State state) {
        StateDTO dto = new StateDTO();
        dto.setId(state.getId());
        dto.setStateName(state.getStateName());
        return dto;
    }

    public State toEntity(StateDTO dto) {
        State state = new State();
        state.setId(dto.getId());
        state.setStateName(dto.getStateName());
        return state;
    }
}
