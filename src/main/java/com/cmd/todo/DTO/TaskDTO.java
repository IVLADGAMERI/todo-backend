package com.cmd.todo.DTO;

import com.cmd.todo.entity.Task;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Getter
public class TaskDTO {
    private final long id;
    private final String title;
    private final String content;
    private final String status;
    private final String priority;
    private final String createdAtDateTime;

    public TaskDTO(Task task, TimeZone timeZone) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.status = task.getStatus().getTitle();
        this.priority = task.getPriority().getTitle();
        this.createdAtDateTime = task.getCreatedAt()
                .toInstant().atZone(timeZone.toZoneId())
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }
}
