package com.cmd.todo.controller;

import com.cmd.todo.DTO.response.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends Oauth2Controller {
    @GetMapping("/user/name")
    public String getUserName(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return getUserLogin(oAuth2User);
    }

    @GetMapping("/user")
    public UserDTO getUserInfo(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return new UserDTO(getUserLogin(oAuth2User),
                getUserAvatarUrl(oAuth2User),
                getUserPageUrl(oAuth2User));
    }
}
