package com.example.NewsApi.mapper;


import com.example.NewsApi.dto.NewsDTO;
import com.example.NewsApi.model.City;
import com.example.NewsApi.model.News;
import com.example.NewsApi.model.State;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NewsMapper {
    public NewsDTO toDto(News news) {
        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setContent(news.getContent());
        dto.setPublishDate(news.getPublishDate());
        dto.setImgUrl(news.getImgUrl());
        dto.setAuthor(news.getAuthor());
        dto.setCities(news.getCities().stream().map(City::getCityName).collect(Collectors.toSet()));
        dto.setStates(news.getStates().stream().map(State::getStateName).collect(Collectors.toSet()));
        dto.setGlobalNews(news.isGlobalNews());
        return dto;
    }
}
