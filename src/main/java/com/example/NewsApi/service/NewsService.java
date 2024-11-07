package com.example.NewsApi.service;

import com.example.NewsApi.dto.NewsDTO;
import com.example.NewsApi.exception.ResourceNotFoundException;
import com.example.NewsApi.mapper.NewsMapper;
import com.example.NewsApi.model.News;
import com.example.NewsApi.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Autowired
    public NewsService(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    public List<NewsDTO> getNewsByDate(Date date, Integer pageSize, Integer offset) {
        List<News> news = newsRepository.findByPublishDate(date);
        return limitAndSortResults(news, pageSize, offset);
    }

    public List<NewsDTO> getNewsByCity(UUID cityId, Integer pageSize, Integer offset) {
        List<News> news = newsRepository.findByCityId(cityId);
        return limitAndSortResults(news, pageSize, offset);
    }

    public List<NewsDTO> getNewsByState(UUID stateId, Integer pageSize, Integer offset) {
        List<News> news = newsRepository.findByStateId(stateId);
        return limitAndSortResults(news, pageSize, offset);
    }

    public List<NewsDTO> getGlobalNews(Integer pageSize, Integer offset) {
        List<News> news = newsRepository.findByGlobalNews(true);
        return limitAndSortResults(news, pageSize, offset);
    }

    public NewsDTO getNewsById(UUID id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("News with ID " + id + " not found"));
        return newsMapper.toDto(news);
    }

    private List<NewsDTO> limitAndSortResults(List<News> news, Integer pageSize, Integer offset) {
        news.sort(Comparator.comparing(News::getPublishDate).reversed());

        if (pageSize != null && pageSize > 0) {
            int start = (offset != null) ? offset : 0;
            news = news.stream()
                    .skip(start)
                    .limit(pageSize)
                    .collect(Collectors.toList());
        }

        return news.stream().map(newsMapper::toDto).collect(Collectors.toList());
    }
}
