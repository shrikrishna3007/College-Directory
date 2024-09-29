package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.UserEntity;
import com.project.collegedirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/")
    public ResponseEntity<Iterable<UserEntity>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> findById(@PathVariable Long id) {
        Optional<UserEntity> user = userService.findById(id);
        if(user!=null) {
            return ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity){
        if (userService.findById(id).isPresent()) {
            userService.updateUser(id, userEntity);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        if (userService.findById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
