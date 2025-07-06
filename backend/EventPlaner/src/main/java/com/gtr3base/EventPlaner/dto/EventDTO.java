package com.gtr3base.EventPlaner.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EventDTO {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private Double budget;
}
