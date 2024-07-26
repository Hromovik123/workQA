package org.example.texttime.service.impl;

import lombok.RequiredArgsConstructor;

import org.example.texttime.auth.repository.AuthRepository;
import org.example.texttime.model.dto.UserDto;
import org.example.texttime.model.entity.UserEntity;
import org.example.texttime.service.AuthService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;

    @Override
    public Integer createUser(UserDto userDto) {
        return authRepository.createUser(userDto.getEmail(),userDto.getUsername(),userDto.getPassword());
    }

    @Override
    public UserDto getUserById(Integer userId) {
        UserEntity userEntity = authRepository.getById(userId);
        return new UserDto().userEntityToUserDto(userEntity);
    }
}
