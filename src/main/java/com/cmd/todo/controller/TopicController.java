package com.cmd.todo.controller;

import com.cmd.todo.DTO.AddTopicDTO;
import com.cmd.todo.DTO.DeleteTopicDTO;
import com.cmd.todo.DTO.TopicDTO;
import com.cmd.todo.DTO.UpdateTopicTitleDTO;
import com.cmd.todo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService service;

    @GetMapping("/topics")
    public List<TopicDTO> getTopics(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return service.getTopicsByUserId(getUserId(oAuth2User));
    }

    @PostMapping("/topic")
    public void addTopic(@AuthenticationPrincipal OAuth2User oAuth2User, @RequestBody AddTopicDTO addTopicDTO) {
        service.addTopic(getUserId(oAuth2User), addTopicDTO);
    }

    @PutMapping("/topic")
    public void updateTopic(@AuthenticationPrincipal OAuth2User oAuth2User,
                            @RequestBody UpdateTopicTitleDTO updateTopicTitleDTO) {
        service.updateTopicTitle(getUserId(oAuth2User), updateTopicTitleDTO);
    }

    @DeleteMapping("/topic")
    public void deleteTopic(@AuthenticationPrincipal OAuth2User oAuth2User,
                            @RequestBody DeleteTopicDTO deleteTopicDTO) {
        service.deleteTopic(getUserId(oAuth2User), deleteTopicDTO);
    }

    private long getUserId(OAuth2User oAuth2User) {
        Integer userId = oAuth2User.getAttribute("id");
        return userId;
    }
}
