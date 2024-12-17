package com.roomrent.roomrent.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomrent.roomrent.dao.UserRepo;
import com.roomrent.roomrent.model.User;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    // private static List<User> list=new ArrayList<>();
    
    // static{
    //     list.add(new User(12,"Gyan Prakash","Allahabad","Active"));
    //     list.add(new User(13,"Gyan ","Allahabad","Active"));
    //     list.add(new User(14," Prakash","Allahabad","Active"));
    // }
    // get all user data
    public List<User> getAllUser(){
        List<User> list=(List<User>)this.userRepo.findAll();
        return list;
    }
    // get single user by id
    public User getBookById(int id){
        User user = null;
        try{
            // user=list.stream().filter(e->e.getId()==id).findFirst().get();
            user = this.userRepo.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    // add new user
    public User addUser(User u){
        // list.add(u);
        User result = this.userRepo.save(u);
        return result;
    }
    public void deleteUser(int id){
        // list = list.stream().filter(user->user.getId()!=id).collect(Collectors.toList());
        this.userRepo.deleteById(id);
    }
    public void updatUser(User user, int id) {
        // list=list.stream().map(u->{
        //     if(u.getId()==id)
        //     {
        //         u.setName(user.getName());
        //         u.setCity(user.getCity());
        //         u.setStatus(user.getStatus());
        //     }
        //     return u;
        // }).collect(Collectors.toList());
        user.setId(id);
        this.userRepo.save(user);
    }
}