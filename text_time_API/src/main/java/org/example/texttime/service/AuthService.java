package org.example.texttime.service;

import org.example.texttime.model.dto.UserDto;

public interface AuthService {
    Integer createUser(UserDto userDto);

    UserDto getUserById(Integer userId);
}
