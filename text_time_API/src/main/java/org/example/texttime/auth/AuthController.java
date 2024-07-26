package org.example.texttime.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.example.texttime.model.dto.UserDto;
import org.example.texttime.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/user")
    public Integer createUser(UserDto requestBody) {
        return authService.createUser(requestBody);
    }

    @GetMapping("/user")
    public UserDto getUser(@JsonProperty("user_id") Integer userId) {
        return authService.getUserById(userId);
    }

    @GetMapping("/login")
    public String login(UserDto requestBody) {
        return "Hello world";
    }

    @PostMapping("/password")
    public Object validPassword(String requestBody) {
        Object o = new Object();
        return o;
    }
}
