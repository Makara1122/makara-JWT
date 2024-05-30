package com.example.makarajwt.feature.content.contentDto;

import lombok.Builder;

@Builder
public record ContentRequest(
        String contentName,
        String contentDescription
) {
}
