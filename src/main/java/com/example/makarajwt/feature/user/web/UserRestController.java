package com.example.makarajwt.feature.user.web;

import com.example.makarajwt.feature.user.UserService;
import com.example.makarajwt.feature.user.userDto.UserRequest;
import com.example.makarajwt.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping("")
    public BaseResponse<Object> ok() {
        return BaseResponse.builder()
                .payload(userService.getAllUsers())
                .message("Get all Success")
                .status(HttpStatus.OK)
                .build();
    }

    @PostMapping("register")
    public BaseResponse<Object> register(@RequestBody UserRequest userRequest) {
        return BaseResponse.builder()
                .payload(userService.register(userRequest))
                .message("Register Success")
                .status(HttpStatus.CREATED)
                .build();
    }

}
