package com.example.makarajwt.feature.auth.authDto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String userId,
        String userUuid,
        String accessToken,
        String refreshToken
) {
}
