package io.payment.ua.web.controllers;

import io.payment.ua.data.exceptions.AuthenticationException;
import io.payment.ua.data.users.security.token.AuthenticationProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationProcessingService authenticationProcessingService;

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestParam("username") String username,
                                            @RequestParam("password") String password,
                                            HttpServletRequest request) throws AuthenticationException {
        return ResponseEntity.ok(authenticationProcessingService
                .authenticateUserWithTokenBasedAuthorizationStrategy(username, password, request));
    }
}
