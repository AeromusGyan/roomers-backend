package com.roomrent.roomrent.dao;

import org.springframework.data.repository.CrudRepository;

import com.roomrent.roomrent.model.User;
public interface UserRepo extends CrudRepository<User, Integer>{
    public User findById(int id);
}
