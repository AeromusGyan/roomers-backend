package com.roomrent.roomrent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roomrent.roomrent.model.User;
import com.roomrent.roomrent.services.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
//  get all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list=this.userService.getAllUser();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list); 
    }
    // get single user
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        User user=this.userService.getBookById(id);
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user)); 
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u = null;
        try{
            u = this.userService.addUser(user);
            System.out.println(user);
            return ResponseEntity.of(Optional.of(u));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id")int id){
        try {
            this.userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updatUser(@RequestBody User user ,@PathVariable("id")int id){
        try {
            this.userService.updatUser(user,id);
            return ResponseEntity.ok().body(user);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
