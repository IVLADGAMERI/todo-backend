package com.cmd.todo.DTO.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@AllArgsConstructor
public class DeleteTaskDTO {
    @PositiveOrZero
    @NotNull
    private long id;
}
