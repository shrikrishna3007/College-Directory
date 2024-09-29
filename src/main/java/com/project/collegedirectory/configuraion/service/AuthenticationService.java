package com.project.collegedirectory.configuraion.service;

import com.project.collegedirectory.authentication.JWTAuthenticationResponse;
import com.project.collegedirectory.authentication.SignInRequest;
import com.project.collegedirectory.authentication.SignUpRequest;
import com.project.collegedirectory.entity.UserEntity;

public interface AuthenticationService {

    UserEntity signUp(SignUpRequest signUpRequest);

    JWTAuthenticationResponse signIn(SignInRequest signInRequest);
}
