package com.gtr3base.EventPlaner.repository;

import com.gtr3base.EventPlaner.dto.enums.TaskStatus;
import com.gtr3base.EventPlaner.model.Task;
import com.gtr3base.EventPlaner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedTo(User user);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByEventId(Long eventId);
}
