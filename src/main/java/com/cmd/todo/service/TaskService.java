package com.cmd.todo.service;

import com.cmd.todo.DTO.request.AddTaskDTO;
import com.cmd.todo.DTO.response.TaskFullDTO;
import com.cmd.todo.TaskStatus;
import com.cmd.todo.entity.Task;
import com.cmd.todo.entity.Topic;
import com.cmd.todo.repository.TaskRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.ZonedDateTime;

@Service
@Validated
public class TaskService {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private TopicService topicService;

    public void addTask(@PositiveOrZero long userId, @Valid AddTaskDTO addTaskDTO) {
        Topic topic = topicService.getTopicByUserIdAndId(userId, addTaskDTO.getTopicId())
                .orElseThrow();
        Task task = new Task();
        task.setTopic(topic);
        task.setStatus(TaskStatus.ACTIVE);
        task.setContent("");
        task.setTitle(addTaskDTO.getTitle());
        task.setUserId(userId);
        task.setPriority(addTaskDTO.getPriority());
        if (addTaskDTO.getExpiresAt() != null && !addTaskDTO.getExpiresAt().isEmpty()) {
            task.setExpiresAt(ZonedDateTime.parse(addTaskDTO.getExpiresAt()));
        }
        repository.save(task);
    }

    public TaskFullDTO getTaskFull(
            @PositiveOrZero long userId,
            @NotNull @PositiveOrZero long id) {
        Task task = repository.getByIdAndUserId(id, userId);
        return new TaskFullDTO(task);
    }
}
