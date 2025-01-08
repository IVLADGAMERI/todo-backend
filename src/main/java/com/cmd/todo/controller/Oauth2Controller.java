package com.cmd.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.server.ResponseStatusException;


public abstract class Oauth2Controller {
    protected static void throwIfPrincipalNull(OAuth2User principal) throws ResponseStatusException {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    protected static long getUserId(OAuth2User oAuth2User) {
        throwIfPrincipalNull(oAuth2User);
        return oAuth2User.<Integer>getAttribute("id");
    }

    protected static String getUserLogin(OAuth2User oAuth2User) {
        throwIfPrincipalNull(oAuth2User);
        return oAuth2User.getAttribute("login");
    }

    protected static String getUserAvatarUrl(OAuth2User oAuth2User) {
        throwIfPrincipalNull(oAuth2User);
        return oAuth2User.getAttribute("avatar_url");
    }

    protected static String getUserPageUrl(OAuth2User oAuth2User) {
        throwIfPrincipalNull(oAuth2User);
        return oAuth2User.getAttribute("html_url");
    }
}
