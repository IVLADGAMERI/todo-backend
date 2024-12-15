package com.cmd.todo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@Data
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @OneToMany
    @JoinColumn(name = "topic_id", nullable = false)
    private List<Task> tasks;
}
