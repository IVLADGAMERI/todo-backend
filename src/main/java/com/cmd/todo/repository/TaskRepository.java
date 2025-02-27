package com.cmd.todo.repository;

import com.cmd.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getAllByUserId(long userId);
    Task getByIdAndUserId(long id, long userId);
}
