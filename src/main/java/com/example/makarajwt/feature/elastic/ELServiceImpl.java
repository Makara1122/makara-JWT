package com.example.makarajwt.feature.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.makarajwt.domain.User;
import com.example.makarajwt.utils.ESUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ELServiceImpl {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<User> autoSuggest(String patialUserName) throws IOException {
        Supplier<Query> supplier = ESUtils.createSupplierAutoSuggest(patialUserName);
        return elasticsearchClient.search(s->s.index("elastic_2024").query(supplier.get()), com.example.makarajwt.domain.User.class);
    }

    public SearchResponse<User> autoSuggestEmail(String patialEmail) throws IOException {
        Supplier<Query> supplier = ESUtils.createSupplierAutoSuggest2(patialEmail);
        return elasticsearchClient.search(s->s.index("elastic_2024").query(supplier.get()), com.example.makarajwt.domain.User.class);
    }
}