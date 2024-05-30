package com.example.makarajwt.feature.content.contentDto;

import lombok.Builder;

@Builder
public record ContentResponse(
        Long id,
        String contentUuid,
        String contentName,
        String contentDescription
) {
}
