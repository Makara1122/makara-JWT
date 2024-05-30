package com.example.makarajwt.feature.content;

import com.example.makarajwt.feature.content.contentDto.ContentRequest;
import com.example.makarajwt.feature.content.contentDto.ContentResponse;

import java.util.List;

public interface ContentService {
    List<ContentResponse> getAllContent();
    ContentResponse createContent(ContentRequest contentRequest);
    ContentResponse updateContent(String contentUuid,ContentRequest contentRequest);
    String deleteContent(String contentUuid);
}
