package com.example.makarajwt.feature.author.authorDto;

import lombok.Builder;

import java.util.Set;

@Builder
public record AuthorRequest(
        String name,
        Set<String> book
) {
}
