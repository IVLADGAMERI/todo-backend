package com.cmd.todo.controller;

import com.cmd.todo.DTO.AddTopicDTO;
import com.cmd.todo.DTO.TopicDTO;
import com.cmd.todo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicsController {
    @Autowired
    private TopicService service;

    @GetMapping("/topics")
    public List<TopicDTO> getTopics(@AuthenticationPrincipal OAuth2User oAuth2User) {
        Integer userId = oAuth2User.getAttribute("id");
        return service.getTopicsByUserId(userId);
    }

    @PostMapping("/topic")
    public void addTopic(@AuthenticationPrincipal OAuth2User oAuth2User, @RequestBody AddTopicDTO addTopicDTO) {
        Integer userId = oAuth2User.getAttribute("id");
        service.addTopic(userId, addTopicDTO);
    }
}
