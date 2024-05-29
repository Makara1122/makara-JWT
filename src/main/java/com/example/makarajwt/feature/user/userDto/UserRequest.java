package com.example.makarajwt.feature.user.userDto;

import com.example.makarajwt.domain.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserRequest(
        String username,
        String password,
        String email,
        Set<String> roles
) {
}
