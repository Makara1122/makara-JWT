package com.example.makarajwt.feature.user.web;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

import com.example.makarajwt.domain.User;
import com.example.makarajwt.feature.elastic.ELServiceImpl;
import com.example.makarajwt.feature.user.UserService;
import com.example.makarajwt.feature.user.userDto.UserRequest;
import com.example.makarajwt.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final ELServiceImpl elService;

    private final UserService userService;

    @GetMapping("")
    public BaseResponse<Object> getAllUsers() {
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


    @GetMapping("/autoSuggest/{partialUserName}")
    public List<String> autoSuggest(@PathVariable String partialUserName) throws IOException {
        SearchResponse<User> searchResponse = elService.autoSuggest(partialUserName);
        List<Hit<User>> hitList = searchResponse.hits().hits();
        List<User> userList = new ArrayList<>();
        for (Hit<User> hit : hitList) {
            userList.add(hit.source());
        }
        List<String> listUserName = new ArrayList<>();
        for (User user : userList) {


            listUserName.add(user.getUsername());

        }
        return listUserName;
    }

    @GetMapping("/autoSuggestEmail/{partialEmail}")
    public List<String> autoSuggestEmail(@PathVariable String partialEmail) throws IOException {
        SearchResponse<User> searchResponse = elService.autoSuggestEmail(partialEmail);
        List<Hit<User>> hitList = searchResponse.hits().hits();
        List<User> userList = new ArrayList<>();
        for (Hit<User> hit : hitList) {
            userList.add(hit.source());
        }
        List<String> listUserName = new ArrayList<>();
        for (User user : userList) {


            listUserName.add(user.getEmail());

        }
        return listUserName;
    }


}
