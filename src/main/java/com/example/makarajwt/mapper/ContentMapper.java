package com.example.makarajwt.mapper;

import com.example.makarajwt.domain.Content;
import com.example.makarajwt.feature.content.contentDto.ContentRequest;
import com.example.makarajwt.feature.content.contentDto.ContentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContentMapper {

    ContentResponse toContentResponse(Content content);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contentUuid", ignore = true)
    Content toContent(ContentRequest contentRequest);
}
