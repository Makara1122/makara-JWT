package com.example.makarajwt.feature.user.userDto;

import com.example.makarajwt.domain.Role;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record UserRequest(
        String username,
        String email,
        String password,
        Set<String> roles,
        boolean isAccountExpired,
        boolean isAccountLocked,
        boolean isCredentialsExpired,
        boolean isDisabled,
        boolean isBlocked
) {
}
