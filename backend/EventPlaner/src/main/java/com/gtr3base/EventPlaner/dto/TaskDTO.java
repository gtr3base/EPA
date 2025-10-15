package com.gtr3base.EventPlaner.dto;

import com.gtr3base.EventPlaner.dto.enums.TaskStatus;
import com.gtr3base.EventPlaner.model.Event;
import com.gtr3base.EventPlaner.model.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskDTO {
    private String name;
    private String description;
    private TaskStatus status;
    private LocalDateTime deadline;

    private Long eventId;
    private Long assignedToId;

}
