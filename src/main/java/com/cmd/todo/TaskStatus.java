package com.cmd.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskStatus {
    ACTIVE("Активно"), FINISHED("Выполнено");
    private final String title;
}
