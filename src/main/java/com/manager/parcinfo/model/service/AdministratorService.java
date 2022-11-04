package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Administrator;
import com.manager.parcinfo.model.dao.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AdministratorService {
    private final AdministratorRepo adminRepo;

    @Autowired
    public AdministratorService(AdministratorRepo adminRepo){
        this.adminRepo = adminRepo;
    }

    public Administrator addAdmin(Administrator admin){
        return this.adminRepo.save(admin);
    }

    public List<Administrator> findAllAdmins(){
        return this.adminRepo.findAll();
    }

    public Administrator updateAdmin(Administrator admin){
        return this.adminRepo.save(admin);
    }

    public void deleteAdmin(Long id){
        this.adminRepo.deleteById(id);
    }

    public Optional<Administrator> getAdmin(Long id){
        return this.adminRepo.findById(id);
    }
}
