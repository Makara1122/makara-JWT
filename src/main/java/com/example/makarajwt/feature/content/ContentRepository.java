package com.example.makarajwt.feature.content;

import com.example.makarajwt.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {
    Optional<Content> findContentByContentUuid(String contentUuid);
    void deleteContentByContentUuid(String contentUuid);
}
