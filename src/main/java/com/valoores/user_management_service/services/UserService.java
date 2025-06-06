package com.valoores.user_management_service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valoores.user_management_service.dto.UserCreateRequestDto;
import com.valoores.user_management_service.dto.UserResponseDto;
import com.valoores.user_management_service.repository.UserRepository;
import com.valoores.user_management_service.mapper.UserMapper;
import com.valoores.user_management_service.model.User;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(UserCreateRequestDto userRequestDto) {
        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            throw new IllegalArgumentException("Username '" + userRequestDto.getUsername() + "' already taken.");
        }
        User user = userMapper.toEntity(userRequestDto);
        // password hashing required
        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            return;
        }
        userRepository.deleteById(id);
    }
}
