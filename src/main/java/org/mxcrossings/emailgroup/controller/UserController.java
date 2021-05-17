package org.mxcrossings.emailgroup.controller;

import org.mxcrossings.emailgroup.model.UserEntity;
import org.mxcrossings.emailgroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        List<UserEntity> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{firstName}")
    public ResponseEntity<UserEntity> getUserByFistName(@PathVariable("firstName") String name){
        UserEntity user = userService.findUserByFirstName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/find/{lastName}")
    public ResponseEntity<UserEntity> getUserByLastName(@PathVariable("lastName") String name){
        UserEntity user = userService.findUserByLastName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id){
        UserEntity user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable("email") String email){
        UserEntity user = userService.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        UserEntity newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        UserEntity updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        //the question mark is because it doesn't return anything
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
