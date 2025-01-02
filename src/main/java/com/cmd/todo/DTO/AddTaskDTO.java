package com.cmd.todo.DTO;

import com.cmd.todo.TaskPriority;
import com.cmd.todo.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
public class AddTaskDTO {
    @NotNull
    @NotBlank
    private final String title;
    @NotNull
    private final TaskPriority priority;
    @NotNull
    @PositiveOrZero
    private final long topicId;
}
