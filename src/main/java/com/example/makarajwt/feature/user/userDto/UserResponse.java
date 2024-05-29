package com.example.makarajwt.feature.user.userDto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserResponse(
        Long id,
        String userUuid,
        String username,
        String email,
        Set<String> roles
) {
}
