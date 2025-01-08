package com.cmd.todo.DTO.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Valid
public class UserDTO {
    @NotNull
    @NotBlank
    private final String login;
    @NotNull
    @NotBlank
    private final String imgUrl;
    @NotNull
    @NotBlank
    private final String profileUrl;
}
