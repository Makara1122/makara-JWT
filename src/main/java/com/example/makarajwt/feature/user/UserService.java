package com.example.makarajwt.feature.user;

import com.example.makarajwt.feature.user.userDto.UserRequest;
import com.example.makarajwt.feature.user.userDto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse register(UserRequest userRequest);

}
