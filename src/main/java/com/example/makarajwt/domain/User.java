package com.example.makarajwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;


import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_tbl")
@Document(indexName = "elastic_2024")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userUuid;
    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role_tbl",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    boolean isAccountExpired;
    boolean isAccountLocked;
    boolean isCredentialsExpired;
    boolean isDisabled;
    boolean isBlocked;


//    this is comment
}
