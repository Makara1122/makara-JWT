package com.example.makarajwt.feature.elastic;

import com.example.makarajwt.domain.Book;
import com.example.makarajwt.domain.Content;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookElasticRepository extends ElasticsearchRepository<Content,Long> {
}
