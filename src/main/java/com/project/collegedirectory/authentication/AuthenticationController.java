package com.project.collegedirectory.authentication;

import com.project.collegedirectory.configuraion.service.AuthenticationService;
import com.project.collegedirectory.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
}
