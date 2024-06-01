package com.example.makarajwt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;



@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "content_tbl")
@Document(indexName = "contents")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contentUuid;
    private String content_name;
    private String contentDescription;
}
