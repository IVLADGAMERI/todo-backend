package com.cmd.todo.DTO.request;

import com.cmd.todo.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@AllArgsConstructor
public class UpdateTaskInfoDTO {
    @NotNull
    @PositiveOrZero
    private final long id;
    @NotNull
    @NotBlank
    private final String newTitle;
    @NotNull
    private final TaskPriority newPriority;
    private final String newExpiresAt;
}
