package com.example.makarajwt.feature.auth.authDto;

import lombok.Builder;

@Builder
public record AuthRequest(
        String email,
        String password
) {
}
