package com.example.makarajwt.feature.auth.authDto;

import lombok.Builder;

@Builder
public record RefreshTokenRequest(
        String refreshToken
) {
}
