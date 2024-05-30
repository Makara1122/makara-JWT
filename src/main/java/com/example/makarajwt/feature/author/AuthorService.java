package com.example.makarajwt.feature.author;

import com.example.makarajwt.feature.author.authorDto.AuthorRequest;
import com.example.makarajwt.feature.author.authorDto.AuthorResponse;

import java.util.List;

public interface AuthorService {

    List<AuthorResponse> getAllAuthors();

    AuthorResponse register(AuthorRequest authorRequest);

    AuthorResponse editAuthor(String uuid, AuthorRequest authorRequest);
}
