package com.cmd.todo.entity;

import com.cmd.todo.TaskPriority;
import com.cmd.todo.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Data
public class Task {
    @PrePersist
    protected void initCreatedAt() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
}
