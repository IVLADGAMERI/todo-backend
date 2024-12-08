package com.cmd.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskPriority {
    HIGH("Высокий"), MEDIUM("Средний"), LOW("Низкий");
    private final String title;
}
