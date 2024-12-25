package com.cmd.todo.repository;

import com.cmd.todo.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> getAllByUserId(long userId);
    Optional<Topic> getByUserIdAndId(long userId, long id);
    @Modifying
    @Transactional
    @Query("DELETE FROM Topic t WHERE t.userId = :userId AND t.id = :id")
    void deleteByUserIdAndId(long userId, long id);
}
