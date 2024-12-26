package com.cmd.todo.controller;

import com.cmd.todo.DTO.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/name")
    public String getUserName(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return oAuth2User.getAttribute("login");
    }

    @GetMapping("/user")
    public UserDTO getUserInfo(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return new UserDTO(oAuth2User.getAttribute("login"),
                oAuth2User.getAttribute("avatar_url"),
                oAuth2User.getAttribute("html_url"));
    }
}
