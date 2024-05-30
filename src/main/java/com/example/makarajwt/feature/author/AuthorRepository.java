package com.example.makarajwt.feature.author;

import com.example.makarajwt.domain.Author;
import com.example.makarajwt.feature.author.authorDto.AuthorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findAuthorByAuthorUuid(String uuid);
}
