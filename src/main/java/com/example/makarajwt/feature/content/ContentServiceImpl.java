package com.example.makarajwt.feature.content;

import com.example.makarajwt.feature.content.contentDto.ContentRequest;
import com.example.makarajwt.feature.content.contentDto.ContentResponse;
import com.example.makarajwt.mapper.ContentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;

    @Override
    public List<ContentResponse> getAllContent() {
        return contentRepository.findAll().stream().map(contentMapper::toContentResponse).toList();
    }

    @Override
    public ContentResponse createContent(ContentRequest contentRequest) {
        var content = contentMapper.toContent(contentRequest);
        content.setContentUuid(UUID.randomUUID().toString());
        return contentMapper.toContentResponse(contentRepository.save(content));
    }

    @Override
    public ContentResponse updateContent(String contentUuid, ContentRequest contentRequest) {
        var contentForUpdate = contentRepository.findContentByContentUuid(contentUuid).orElseThrow(()-> new RuntimeException("Content not found"));
        contentForUpdate.setContent_name(contentRequest.content_name());
        contentForUpdate.setContentDescription(contentRequest.contentDescription());
        return contentMapper.toContentResponse(contentRepository.save(contentForUpdate));
    }

    @Override
    public String deleteContent(String contentUuid) {
        var contentForDelete = contentRepository.findContentByContentUuid(contentUuid).orElseThrow(()-> new RuntimeException("Content not found"));
        contentRepository.delete(contentForDelete);
        return  "Content  has been deleted";
    }
}
