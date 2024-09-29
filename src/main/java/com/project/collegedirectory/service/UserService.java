package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.UserEntity;
import com.project.collegedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public String updateUser(Long id, UserEntity userEntity) {
        Optional<UserEntity> user=userRepository.findById(id);
        if(user.isPresent()){
            UserEntity userEntity1=user.get();
            userEntity1.setName(userEntity.getName());
            userEntity1.setEmail(userEntity.getEmail());
            userEntity1.setPassword(userEntity.getPassword());
            userEntity1.setPhone(userEntity.getPhone());
            userEntity1.setUsername(userEntity.getUsername());
            userRepository.save(userEntity1);
            return "User updated successfully";
        }
        return "User not found";
    }

    public String deleteUser(Long id) {
        Optional<UserEntity> user=userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }
}
