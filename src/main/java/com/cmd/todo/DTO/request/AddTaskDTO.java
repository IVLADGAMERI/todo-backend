package com.cmd.todo.DTO.request;

import com.cmd.todo.TaskPriority;
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
    private final String expiresAt;
    @NotNull
    @PositiveOrZero
    private final long topicId;
}
