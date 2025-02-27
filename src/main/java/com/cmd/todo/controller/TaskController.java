package com.cmd.todo.controller;

import com.cmd.todo.DTO.request.AddTaskDTO;
import com.cmd.todo.DTO.request.DeleteTaskDTO;
import com.cmd.todo.DTO.request.UpdateTaskContentDTO;
import com.cmd.todo.DTO.request.UpdateTaskInfoDTO;
import com.cmd.todo.DTO.response.TaskFullDTO;
import com.cmd.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController extends Oauth2Controller {
    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public void addTask(@AuthenticationPrincipal OAuth2User oAuth2User, @RequestBody AddTaskDTO addTaskDTO) {
        taskService.addTask(getUserId(oAuth2User), addTaskDTO);
    }

    @PutMapping("/task/content")
    public void updateTaskContent(@AuthenticationPrincipal OAuth2User oAuth2User,
                                  @RequestBody UpdateTaskContentDTO updateTaskContentDTO) {
        taskService.updateTaskContent(getUserId(oAuth2User), updateTaskContentDTO);
    }

    @GetMapping("/task")
    public TaskFullDTO getTaskById(@AuthenticationPrincipal OAuth2User oAuth2User,
                                   @RequestParam long id) {
        return taskService.getTaskFull(getUserId(oAuth2User), id);
    }

    @DeleteMapping("/task")
    public void deleteTaskById(@AuthenticationPrincipal OAuth2User oAuth2User,
                               @RequestBody DeleteTaskDTO deleteTaskDTO) {
        taskService.deleteTask(getUserId(oAuth2User), deleteTaskDTO);
    }

    @PutMapping("/task/info")
    public void updateTaskInfo(@AuthenticationPrincipal OAuth2User oAuth2User,
                               @RequestBody UpdateTaskInfoDTO updateTaskInfoDTO) {
        taskService.updateTaskInfo(getUserId(oAuth2User), updateTaskInfoDTO);
    }
}
