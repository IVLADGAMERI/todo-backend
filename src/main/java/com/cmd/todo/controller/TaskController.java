package com.cmd.todo.controller;

import com.cmd.todo.DTO.AddTaskDTO;
import com.cmd.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public void addTask(@AuthenticationPrincipal OAuth2User oAuth2User, @RequestBody AddTaskDTO addTaskDTO) {
        taskService.addTask(getUserId(oAuth2User), addTaskDTO);
    }

    private long getUserId(OAuth2User oAuth2User) {
        Integer userId = oAuth2User.getAttribute("id");
        return userId;
    }
}
