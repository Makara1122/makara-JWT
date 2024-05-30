package com.example.makarajwt.feature.author.web;

import com.example.makarajwt.feature.author.AuthorService;
import com.example.makarajwt.feature.author.authorDto.AuthorRequest;
import com.example.makarajwt.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping("")
    public BaseResponse<Object> getAllAuthors() {
        return BaseResponse.
                builder().
                payload(authorService.getAllAuthors()).
                message("Get All succesfully").
                status(HttpStatus.CREATED).
                build();
    }

    @PostMapping("")
    public BaseResponse<Object> registerAuthor(@RequestBody AuthorRequest authorRequest) {
        return BaseResponse.
                builder().
                status(HttpStatus.CREATED).
                message("Register succesfully").
                payload(authorService.register(authorRequest)).
                build();
    }

    @PutMapping("/{uuid}")
    public BaseResponse<Object> updateAuthor(@PathVariable String uuid,@RequestBody AuthorRequest authorRequest) {
        return BaseResponse.
                builder().
                payload(authorService.editAuthor(uuid, authorRequest)).
                message("Update successfully").
                status(HttpStatus.CREATED).
                build();
    }
}
