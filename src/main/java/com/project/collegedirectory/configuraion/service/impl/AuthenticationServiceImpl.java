package com.project.collegedirectory.configuraion.service.impl;

import com.project.collegedirectory.authentication.JWTAuthenticationResponse;
import com.project.collegedirectory.authentication.SignInRequest;
import com.project.collegedirectory.authentication.SignUpRequest;
import com.project.collegedirectory.configuraion.service.AuthenticationService;
import com.project.collegedirectory.configuraion.service.JWTService;
import com.project.collegedirectory.entity.UserEntity;
import com.project.collegedirectory.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    @Override
    public UserEntity signUp(SignUpRequest signUpRequest) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(signUpRequest.getUsername());
        userEntity.setEmail(signUpRequest.getEmail());
        userEntity.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userEntity.setName(signUpRequest.getName());
        userEntity.setPhone(signUpRequest.getPhone());
        userEntity.setRole(signUpRequest.getRole());
        return userRepository.save(userEntity);
    }

    @Override
    public JWTAuthenticationResponse signIn(SignInRequest signInRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
        var user=userRepository.findByUsername(signInRequest.getUsername());
        var jwt=jwtService.generateToken(user);

        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),user);

        JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }
}
