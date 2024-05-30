package com.example.makarajwt.security;

import com.example.makarajwt.domain.User;
import com.example.makarajwt.feature.user.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {


    private final UserRepository userRepository;


    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {

        User user = userRepository.findByEmail(source.getSubject()).
                orElseThrow(()->new RuntimeException("Email not found"));

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);

        return new UsernamePasswordAuthenticationToken(
                customUserDetails,
                "",
                customUserDetails.getAuthorities());
    }
}
