package com.example.makarajwt.feature.elastic;

import com.example.makarajwt.domain.User;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface ElasticUserRepository extends ElasticsearchRepository<User,Long> {
}
