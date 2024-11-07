package com.example.NewsApi.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class NewsDTO {
    private UUID id;
    private String title;
    private String content;
    private Date publishDate;
    private String imgUrl;
    private String author;
    private Set<String> cities;
    private Set<String> states;
    private boolean globalNews;
}
