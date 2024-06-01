package com.example.makarajwt.feature.content.contentDto;

import lombok.Builder;

@Builder
public record ContentRequest(
        String content_name,
        String contentDescription
) {
}
