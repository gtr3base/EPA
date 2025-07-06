package com.gtr3base.EventPlaner.service;

import com.gtr3base.EventPlaner.dto.TaskDTO;
import com.gtr3base.EventPlaner.dto.enums.TaskStatus;
import com.gtr3base.EventPlaner.exception.ResourceNotFoundException;
import com.gtr3base.EventPlaner.model.Event;
import com.gtr3base.EventPlaner.model.Task;
import com.gtr3base.EventPlaner.model.User;
import com.gtr3base.EventPlaner.repository.EventRepository;
import com.gtr3base.EventPlaner.repository.TaskRepository;
import com.gtr3base.EventPlaner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Transactional
    public Task createTask(TaskDTO taskDTO){
        Task task = Task
                .builder()
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .deadline(taskDTO.getDeadline())
                .build();

        Event event = eventRepository.findById(taskDTO.getEventId()).orElseThrow(
                () -> new RuntimeException("Event not found")
        );

        task.setEvent(event);

        task.setAssignedTo(userRepository.findById(taskDTO.getAssignedToId()).orElseThrow(
                () -> new RuntimeException("AssignedTo not found")
        ));

        return taskRepository.save(task);
    }

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    @Transactional
    public Task updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setDeadline(taskDTO.getDeadline());
         User user = userRepository.findById(taskDTO.getAssignedToId())
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + taskDTO.getAssignedToId()));
            task.setAssignedTo(user);

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        taskRepository.delete(task);
    }

    public List<Task> getTasksByEvent(Long eventId) {
        return taskRepository.findByEventId(eventId);
    }

    public List<Task> getTasksByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return taskRepository.findByAssignedTo(user);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
}
