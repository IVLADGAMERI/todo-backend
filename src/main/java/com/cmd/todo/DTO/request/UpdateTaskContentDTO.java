package com.cmd.todo.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
public class UpdateTaskContentDTO {
    @PositiveOrZero
    private long taskId;
    @NotNull
    @NotBlank
    private String newContent;
}
