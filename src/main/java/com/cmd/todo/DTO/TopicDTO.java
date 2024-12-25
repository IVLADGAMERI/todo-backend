package com.cmd.todo.DTO;

import com.cmd.todo.entity.Task;
import com.cmd.todo.entity.Topic;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TopicDTO {
    private final long id;
    private final String title;
    private final List<TaskDTO> tasks;

    public TopicDTO(Topic topic) {
        this.title = topic.getTitle();
        this.tasks = new ArrayList<>();
        this.id = topic.getId();
        List<Task> tasksEntities = topic.getTasks();
        if (tasksEntities != null && !tasksEntities.isEmpty()) {
            tasksEntities.forEach((item) -> tasks.add(new TaskDTO(item)));
        }
    }
}
