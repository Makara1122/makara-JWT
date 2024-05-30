package com.example.makarajwt.feature.author.authorDto;

import lombok.Builder;

import java.util.List;
import java.util.Set;

@Builder
public record AuthorResponse(
        String name,
        Long id,
        String authorUuid,
        Set<String> books
) {
}
