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
public class UpdateTopicTitleDTO {
    @NotNull
    @PositiveOrZero
    private final long id;
    @NotNull
    @NotBlank
    private final String newTitle;
}
