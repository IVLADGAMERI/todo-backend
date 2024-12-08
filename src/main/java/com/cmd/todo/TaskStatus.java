package com.cmd.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskStatus {
    ACTIVE("АктивнО"), FINISHED("Выполнено");
    private final String title;
}
