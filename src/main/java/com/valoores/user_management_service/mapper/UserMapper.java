package com.valoores.user_management_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.valoores.user_management_service.dto.UserCreateRequestDto;
import com.valoores.user_management_service.dto.UserResponseDto;
import com.valoores.user_management_service.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdOn", ignore = true) 
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "passwordHash", ignore = true) 
    User toEntity(UserCreateRequestDto dto); 

    UserResponseDto toDto(User entity);


}
