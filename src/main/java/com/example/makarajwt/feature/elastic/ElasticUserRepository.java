package com.example.makarajwt.feature.elastic;

import com.example.makarajwt.domain.User;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@EnableElasticsearchRepositories(basePackages = "com.example.makarajwt.feature.elastic")
public interface ElasticUserRepository extends ElasticsearchRepository<User,Long> {
}
