package com.example.makarajwt.feature.content.web;

import com.example.makarajwt.feature.content.ContentService;
import com.example.makarajwt.feature.content.contentDto.ContentRequest;
import com.example.makarajwt.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contents")
public class ContentRestController {

    private final ContentService contentService;

    @GetMapping("/read")
    public BaseResponse<Object> getAllContents() {
        return BaseResponse.
                builder().
                payload(contentService.getAllContent()).
                message("Success get all contents").
                status(HttpStatus.OK).
                build();
    }

    @PostMapping("")
    public BaseResponse<Object> createContent(@RequestBody ContentRequest contentRequest) {
        return  BaseResponse.
                builder().
                payload(contentService.createContent(contentRequest)).
                status(HttpStatus.CREATED).
                message("Success create content").
                build();
    }

    @PutMapping("/{contentUuid}")
    public BaseResponse<Object> updateContent(@PathVariable String contentUuid,@RequestBody ContentRequest contentRequest) {
        return BaseResponse.
                builder().
                payload(contentService.updateContent(contentUuid,contentRequest)).
                message("Success update content").
                status(HttpStatus.CREATED).
                build();
    }

    @DeleteMapping("/{contentUuid}")
    public BaseResponse<Object> deleteContent(@PathVariable String contentUuid) {
        return BaseResponse.
                builder().
                payload(contentService.deleteContent(contentUuid)).
                message("Success delete content").
                status(HttpStatus.NO_CONTENT).
                build();
    }
}
