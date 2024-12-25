package com.cmd.todo.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
public class DeleteTopicDTO {
    @NotNull
    @PositiveOrZero
    private final long id;
}
