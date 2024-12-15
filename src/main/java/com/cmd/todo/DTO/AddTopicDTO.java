package com.cmd.todo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Validated
@AllArgsConstructor
@Getter
public class AddTopicDTO {
    @NotNull
    @NotBlank
    private final String title;
}
