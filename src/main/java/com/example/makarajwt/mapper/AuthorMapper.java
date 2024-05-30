package com.example.makarajwt.mapper;

import com.example.makarajwt.domain.Author;
import com.example.makarajwt.domain.Book;
import com.example.makarajwt.feature.author.authorDto.AuthorRequest;
import com.example.makarajwt.feature.author.authorDto.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Named("toBooks")
   default Set<String> toBooks(Set<Book> books) {
        return books.stream().map(Book::getTitle).collect(Collectors.toSet());
    }

    @Mapping(target = "books", expression = "java(toBooks(author.getBooks()))")
    AuthorResponse toAuthorResponse(Author author);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorUuid", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toAuthor(AuthorRequest authorRequest);
}
