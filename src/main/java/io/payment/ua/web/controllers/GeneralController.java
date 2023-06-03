package io.payment.ua.web.controllers;

import io.payment.ua.data.users.repository.models.AbstractUserModel;
import io.payment.ua.data.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GeneralController {
    private final UserService userService;

    @PostMapping("/api/user/create")
    public ResponseEntity<?> createUser(@RequestBody AbstractUserModel abstractUserModel) {
        abstractUserModel = userService.saveAbstractUserModel(abstractUserModel);
        return ResponseEntity.ok(abstractUserModel);
    }
}
