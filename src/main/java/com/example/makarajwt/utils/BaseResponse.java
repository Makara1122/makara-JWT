package com.example.makarajwt.utils;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record BaseResponse<T>(
        T payload,
        String message,
        HttpStatus status,
        Object metadata
) {

}
