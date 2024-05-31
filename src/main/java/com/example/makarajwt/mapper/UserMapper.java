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
    @Mapping(target = "isAccountExpired", source = "accountExpired")
    @Mapping(target = "isAccountLocked", source = "accountLocked")
    @Mapping(target = "isCredentialsExpired", source = "credentialsExpired")
    @Mapping(target = "isDisabled", source = "disabled")
    @Mapping(target = "isBlocked", source = "blocked")
    UserResponse toUserResponse(User user);

    @Name("mapRoles")
    default Set<String> mapRoles(Set<Role> roles){
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userUuid", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "accountExpired", source = "isAccountExpired")
    @Mapping(target = "accountLocked", source = "isAccountLocked")
    @Mapping(target = "credentialsExpired", source = "isCredentialsExpired")
    @Mapping(target = "disabled", source = "isDisabled")
    @Mapping(target = "blocked", source = "isBlocked")
    User toUser(UserRequest userRequest);
}
