package org.example.kingcrabback.domain.user.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.user.controller.LoginRequest;
import org.example.kingcrabback.domain.user.controller.TokenResponse;
import org.example.kingcrabback.domain.user.entity.User;
import org.example.kingcrabback.domain.user.exception.UserPasswordMissMatchException;
import org.example.kingcrabback.domain.user.exception.UsernameAlreadyExistException;
import org.example.kingcrabback.domain.user.repository.UserRepository;
import org.example.kingcrabback.domain.utill.jwt.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Getter
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUserName(loginRequest.getUserName()).orElseThrow(()-> UsernameAlreadyExistException.EXCEPTION);
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw UserPasswordMissMatchException.EXCEPTION;
        }
        System.out.println(user.getUserName());
        return new TokenResponse(jwtProvider.createAccessToken(user.getUserName()));

    }

    @Transactional
    public void signup(LoginRequest loginRequest) {
        if(!userRepository.existsByUserName(loginRequest.getUserName())){
            userRepository.save(
                    User.builder()
                            .userName(loginRequest.getUserName())
                            .password(passwordEncoder.encode(loginRequest.getPassword()))
                            .build()
            );
        }else{
            throw UsernameAlreadyExistException.EXCEPTION;
        }
    }
}
