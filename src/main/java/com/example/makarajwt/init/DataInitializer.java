package com.example.makarajwt.init;

import com.example.makarajwt.domain.Authority;
import com.example.makarajwt.domain.Role;
import com.example.makarajwt.feature.authority.AuthorityRepository;
import com.example.makarajwt.feature.role.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    @Transactional
    public void initData() {
        initAuthority();
        initRole();
    }

    private void initAuthority() {
        Set<String> authorities = Set.of("READ", "WRITE", "DELETE");
        if (authorityRepository.count() == 0) {
            for (var auth : authorities) {
                var authority = new Authority();
                authority.setAuthorityUuid(UUID.randomUUID().toString());
                authority.setName(auth);
                authorityRepository.save(authority);
            }
        }
    }

    private void initRole() {
        Set<String> roles = Set.of("ADMIN", "USER");
        var allAuthoritie = new HashSet<>(authorityRepository.findAll());
        if ( roleRepository.count() == 0) {
            for (var role : roles) {

                if (role.equals("ADMIN")) {
                    var r = new Role();
                    r.setName(role);
                    r.setAuthorities(allAuthoritie);
                    r.setRoleUuid(UUID.randomUUID().toString());
                    roleRepository.save(r);
                } else if (role.equals("USER")) {
                    var r = new Role();
                    r.setName(role);
                    r.setRoleUuid(UUID.randomUUID().toString());
                    r.setAuthorities(allAuthoritie.stream().filter(a -> a.getName().equals("READ")).collect(Collectors.toSet()));
                    roleRepository.save(r);
                }
            }
        }
    }
}
