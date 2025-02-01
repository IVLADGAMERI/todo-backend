package com.cmd.todo.service;

import com.cmd.todo.DTO.request.AddTaskDTO;
import com.cmd.todo.DTO.request.DeleteTaskDTO;
import com.cmd.todo.DTO.request.UpdateTaskContentDTO;
import com.cmd.todo.DTO.request.UpdateTaskInfoDTO;
import com.cmd.todo.DTO.response.TaskFullDTO;
import com.cmd.todo.TaskStatus;
import com.cmd.todo.entity.Task;
import com.cmd.todo.entity.Topic;
import com.cmd.todo.exception.IllegalDataMutationException;
import com.cmd.todo.repository.TaskRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.ZonedDateTime;

@Service
@Validated
@Slf4j
public class TaskService {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private TopicService topicService;

    public void deleteTask(@PositiveOrZero long userId, @Valid DeleteTaskDTO deleteTaskDTO) {
        Task task = repository.getByIdAndUserId(deleteTaskDTO.getId(), userId);
        if (task.getTopic().getUserId() == userId) {
            repository.delete(task);
            return;
        }
        throw new IllegalDataMutationException("Неверный id");
    }

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

    public void updateTaskInfo(@PositiveOrZero long userId, @Valid UpdateTaskInfoDTO updateTaskInfoDTO) {
        Task task = repository.getByIdAndUserId(updateTaskInfoDTO.getId(), userId);
        log.info(updateTaskInfoDTO.getNewPriority().toString());
        task.setTitle(updateTaskInfoDTO.getNewTitle());
        task.setPriority(updateTaskInfoDTO.getNewPriority());
        if (updateTaskInfoDTO.getNewExpiresAt() != null && !updateTaskInfoDTO.getNewExpiresAt().isEmpty()) {
            task.setExpiresAt(ZonedDateTime.parse(updateTaskInfoDTO.getNewExpiresAt()));
        } else {
            task.setExpiresAt(null);
        }
        repository.save(task);
    }

    public void updateTaskContent(@PositiveOrZero long userId, @Valid UpdateTaskContentDTO updateTaskContentDTO) {
        Task task = repository.getByIdAndUserId(updateTaskContentDTO.getTaskId(), userId);
        task.setContent(updateTaskContentDTO.getNewContent());
        repository.save(task);
    }

    public TaskFullDTO getTaskFull(
            @PositiveOrZero long userId,
            @NotNull @PositiveOrZero long id) {
        Task task = repository.getByIdAndUserId(id, userId);
        return new TaskFullDTO(task);
    }
}
