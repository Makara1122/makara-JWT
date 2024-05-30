package com.example.makarajwt.feature.author;

import com.example.makarajwt.domain.Book;
import com.example.makarajwt.feature.author.authorDto.AuthorRequest;
import com.example.makarajwt.feature.author.authorDto.AuthorResponse;
import com.example.makarajwt.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final  AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::toAuthorResponse).toList();
    }

    @Override
    public AuthorResponse register(AuthorRequest authorRequest) {
        var author = authorMapper.toAuthor(authorRequest);
        author.setAuthorUuid(UUID.randomUUID().toString());
        Set<Book> books = new HashSet<>();
        authorRequest.book().forEach(book -> {
            var newBook = new Book();
            newBook.setTitle(book);
            newBook.setBookUuid(UUID.randomUUID().toString());
            books.add(newBook);
        });
        author.setBooks(books);
        return authorMapper.toAuthorResponse(authorRepository.save(author));
    }

    @Override
    public AuthorResponse editAuthor(String uuid, AuthorRequest authorRequest) {
        var authorForUpdate = authorRepository.findAuthorByAuthorUuid(uuid).orElseThrow(()->new RuntimeException("Author not found"));
        authorForUpdate.setName(authorRequest.name());
        Set<Book> books = new HashSet<>();
        authorRequest.book().forEach(book -> {
            var newBook = new Book();
            newBook.setTitle(book);
            newBook.setBookUuid(UUID.randomUUID().toString());
            books.add(newBook);
        });
        authorForUpdate.setBooks(books);
        return authorMapper.toAuthorResponse(authorRepository.save(authorForUpdate));
    }
}


