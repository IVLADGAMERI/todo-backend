package com.cmd.todo.service;

import com.cmd.todo.DTO.AddTopicDTO;
import com.cmd.todo.DTO.TopicDTO;
import com.cmd.todo.entity.Topic;
import com.cmd.todo.repository.TopicRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class TopicService {
    @Autowired
    private TopicRepository repository;

    public List<TopicDTO> getTopicsByUserId(@PositiveOrZero long userId) {
        List<Topic> topics = repository.getAllByUserId(userId);
        return toDTOList(topics);
    }

    public void addTopic(@PositiveOrZero long userId, @Valid AddTopicDTO addTopicDTO) {
        Topic topic = new Topic();
        topic.setTitle(addTopicDTO.getTitle());
        topic.setUserId(userId);
        repository.save(topic);
    }

    private List<TopicDTO> toDTOList(@NotNull List<Topic> topics) {
        List<TopicDTO> result = new ArrayList<>();
        for (Topic item : topics) {
            result.add(toDTO(item));
        }
        return result;
    }

    private TopicDTO toDTO(Topic topic) {
        return new TopicDTO(topic);
    }
}
