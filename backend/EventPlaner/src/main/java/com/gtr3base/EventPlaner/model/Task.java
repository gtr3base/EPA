package com.gtr3base.EventPlaner.model;

import com.gtr3base.EventPlaner.dto.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private TaskStatus status;
    private LocalDateTime deadline;

    @ManyToOne
    private Event event;

    @ManyToOne
    private User assignedTo;
}
