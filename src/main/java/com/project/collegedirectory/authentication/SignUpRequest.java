package com.project.collegedirectory.authentication;

import com.project.collegedirectory.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotBlank(message = "Aadhaar number cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    @NotBlank(message = "Role cannot be blank")
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 5, message = "Name must be minimum 5 characters")
    private String name;
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 10, max =10, message = "Phone number must be 10 digits")
    private String phone;
}
