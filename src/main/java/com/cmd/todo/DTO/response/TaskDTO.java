package com.cmd.todo.DTO.response;

import com.cmd.todo.entity.Task;
import lombok.Getter;

@Getter
public class TaskDTO {
    private final long id;
    private final String title;
    private final String statusName;
    private final String priorityName;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.statusName = task.getStatus().name();
        this.priorityName = task.getPriority().name();
    }
}
