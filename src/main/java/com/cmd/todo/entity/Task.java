package com.cmd.todo.entity;

import com.cmd.todo.TaskPriority;
import com.cmd.todo.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Data
public class Task {
    @PrePersist
    protected void initCreatedAt() {
        this.createdAt = ZonedDateTime.now(ZoneOffset.UTC);
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
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private ZonedDateTime createdAt;
    @Column(name = "expires_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime expiresAt;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;
}
