package com.project.collegedirectory.authentication;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
