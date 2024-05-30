package com.example.makarajwt.feature.auth;

import com.example.makarajwt.feature.auth.authDto.AuthRequest;
import com.example.makarajwt.feature.auth.authDto.RefreshTokenRequest;
import com.example.makarajwt.feature.user.UserService;
import com.example.makarajwt.feature.user.userDto.UserRequest;
import com.example.makarajwt.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    private final AuthServiceImpl authService;
    private final UserService userService;

    @PostMapping("/login")
    public BaseResponse<Object> login (@RequestBody AuthRequest authRequest) {

        System.out.println(authRequest + " Here is AuthRequest");

        return BaseResponse
                .builder()
                .payload(authService.login(authRequest))
                .message("Login Successfully !")
                .status(HttpStatus.CREATED)
                .build();
    }
    @PostMapping("/refresh-token")
    public BaseResponse<Object> refresh (@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return BaseResponse
                .builder()
                .payload(authService.refreshToken(refreshTokenRequest))
                .message("Refresh Token Successfully !")
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/register")
    public BaseResponse<Object> register (@RequestBody UserRequest userRequest) {
        return  BaseResponse
                .builder()
                .payload(userService.register(userRequest))
                .message("Register Success")
                .status(HttpStatus.CREATED)
                .build();
    }
}
