package com.example.NewsApi.controller;

import com.example.NewsApi.dto.NewsDTO;
import com.example.NewsApi.service.NewsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<NewsDTO>> getNewsByDate(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "offset", required = false) Integer offset) {  // Dodano offset
        List<NewsDTO> news = newsService.getNewsByDate(date, pageSize, offset);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/by-city/{cityId}")
    public ResponseEntity<List<NewsDTO>> getNewsByCity(
            @PathVariable UUID cityId,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "offset", required = false) Integer offset) {  // Dodano offset
        List<NewsDTO> news = newsService.getNewsByCity(cityId, pageSize, offset);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/by-state/{stateId}")
    public ResponseEntity<List<NewsDTO>> getNewsByState(
            @PathVariable UUID stateId,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "offset", required = false) Integer offset) {  // Dodano offset
        List<NewsDTO> news = newsService.getNewsByState(stateId, pageSize, offset);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/global")
    public ResponseEntity<List<NewsDTO>> getGlobalNews(
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "offset", required = false) Integer offset) {  // Dodano offset
        List<NewsDTO> news = newsService.getGlobalNews(pageSize, offset);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable UUID id) {
        NewsDTO news = newsService.getNewsById(id);
        return ResponseEntity.ok(news);
    }
}
