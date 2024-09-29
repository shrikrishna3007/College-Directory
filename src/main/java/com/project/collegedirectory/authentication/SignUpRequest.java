package com.project.collegedirectory.authentication;

import com.project.collegedirectory.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class SignUpRequest {

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String name;
    private String email;
    private String phone;
}
