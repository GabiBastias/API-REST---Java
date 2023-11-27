package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserServices;

@RestController
@RequestMapping("/user") // Original Path
public class UserController {
    
    @Autowired
    private UserServices userServices;

    @GetMapping // Get Petition right now blank
    public ArrayList<UserModel> getUsers(){
        return this.userServices.getUsers();
    }

    @PostMapping // Post petition
    public UserModel saveUser(@RequestBody UserModel user){ // Info by Body
        return this.userServices.saveUser(user);
    }

    @GetMapping(path = "/{id}") // Secondary Path (variable in this case)
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){ // Variable by path
        return this.userServices.getUserById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel user, @PathVariable("id") Long id){
        return this.userServices.updateUserById(user, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        boolean ok = this.userServices.deleteUserById(id); 
        if (ok) return "User with id " + id + " delete successfully.";
        else return "Can't be deleted, please verify the information and try again.";
    }
}
