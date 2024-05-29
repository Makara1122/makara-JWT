package com.example.makarajwt.mapper;

import com.example.makarajwt.domain.Role;
import com.example.makarajwt.domain.User;
import com.example.makarajwt.feature.user.userDto.UserRequest;
import com.example.makarajwt.feature.user.userDto.UserResponse;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserResponse toUserResponse(User user);

    @Name("mapRoles")
    default Set<String> mapRoles(Set<Role> roles){
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userUuid", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toUser(UserRequest userRequest);
}
