package com.manager.parcinfo.model.service;


import com.manager.parcinfo.model.bo.User;
import com.manager.parcinfo.model.dao.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class userService {
    private final userRepo userRepo;

    @Autowired
    public userService(com.manager.parcinfo.model.dao.userRepo userRepo) { this.userRepo = userRepo; }

    public User addUser(User user){ return this.userRepo.save(user); }

    public List<User> findAllUsers(){
        return this.userRepo.findAll();
    }

    public User updateUser(User user){
        return this.userRepo.save(user);
    }

    public void deleteUser(Long id){
        this.userRepo.deleteById(id);
    }

    public Optional<User> getUser(Long id){
        return this.userRepo.findById(id);
    }

}
