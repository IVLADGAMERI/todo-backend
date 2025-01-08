package com.cmd.todo.DTO.response;

import com.cmd.todo.entity.Task;
import lombok.Getter;

@Getter
public class TaskFullDTO {
    private final long id;
    private final String title;
    private final String statusName;
    private final String priorityName;
    private final String content;
    private final String createdAt;

    public TaskFullDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.priorityName = task.getPriority().name();
        this.statusName = task.getStatus().name();
        this.content = task.getContent();
        this.createdAt = task.getCreatedAt().toLocalDateTime().toString();
    }
}
