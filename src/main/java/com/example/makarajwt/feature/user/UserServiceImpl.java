package com.example.makarajwt.feature.user;

import com.example.makarajwt.domain.Role;
import com.example.makarajwt.feature.user.userDto.UserRequest;
import com.example.makarajwt.feature.user.userDto.UserResponse;
import com.example.makarajwt.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse register(UserRequest userRequest) {
        var user = userMapper.toUser(userRequest);
        user.setUserUuid(UUID.randomUUID().toString());
        Set<Role> roles = new HashSet<>();
        for (var role : userRequest.roles()) {
            var r = new Role();
            r.setName(role);
            r.setRoleUuid(UUID.randomUUID().toString());
            roles.add(r);
        }
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }
}
