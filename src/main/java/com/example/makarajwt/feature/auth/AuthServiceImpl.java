package com.example.makarajwt.feature.auth;

import com.example.makarajwt.feature.auth.authDto.AuthRequest;
import com.example.makarajwt.feature.auth.authDto.AuthResponse;
import com.example.makarajwt.feature.auth.authDto.RefreshTokenRequest;
import com.example.makarajwt.security.JwtToUserConverter;
import com.example.makarajwt.security.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {

    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final TokenGenerator tokenGenerator;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public AuthResponse login (AuthRequest authRequest) {
        Authentication authentication = daoAuthenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.password(),authRequest.email())
        );
        return tokenGenerator.generateTokens(authentication);
    }

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        Authentication authentication = jwtAuthenticationProvider.authenticate(
                new BearerTokenAuthenticationToken(refreshTokenRequest.refreshToken())
        );
        return tokenGenerator.generateTokens(authentication);
    }
}
