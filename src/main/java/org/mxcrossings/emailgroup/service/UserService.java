package org.mxcrossings.emailgroup.service;
//this package uses the repository to do all of the CRUD  operations..

import org.apache.catalina.User;
import org.mxcrossings.emailgroup.exceptions.UserNotFoundException;
import org.mxcrossings.emailgroup.model.UserEntity;
import org.mxcrossings.emailgroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //method to return list of all users
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    //method to add/create an user
    public UserEntity addUser(UserEntity user) { return new UserEntity(); }

    //method to update/save an user
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    //method to find User by Id
    public UserEntity findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by ID: " + id + "was not found"));
    }

    //method to find User by Name
    public UserEntity findUserByName(String name){
        return userRepository.findUserByName(name).orElseThrow(() -> new UserNotFoundException("User by Name: " + name + "was not found"));
    }

    //method to find User by Email
    public UserEntity findUserByEmail(String email){
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User by Email: " + email + "was not found"));
    }

    //method to delete an user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
