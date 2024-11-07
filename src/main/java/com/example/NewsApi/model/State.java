package com.example.NewsApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @ManyToMany(mappedBy = "states")
    private Set<News> news = new HashSet<>();
}
