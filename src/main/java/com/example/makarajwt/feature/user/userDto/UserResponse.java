package com.example.makarajwt.feature.user.userDto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record UserResponse(
        Long id,
        String userUuid,
        String username,
        String email,
        Set<String> roles,
        boolean isAccountExpired,
        boolean isAccountLocked,
        boolean isCredentialsExpired,
        boolean isDisabled,
        boolean isBlocked
) {
}
