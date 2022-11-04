package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Departement;
import com.manager.parcinfo.model.dao.departementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class departementService {
    private final departementRepo depRepo;

    @Autowired
    public departementService(departementRepo depRepo) { this.depRepo = depRepo; }

    public Departement addDepartement(Departement dep) { return  this.depRepo.save(dep); }

    public List<Departement> findAlldepartements(){
        return this.depRepo.findAll();
    }

    public Departement updateDepartement(Departement departement){ return this.depRepo.save(departement); }

    public void deleteDepartement(Long id){
        this.depRepo.deleteById(id);
    }

    public Optional<Departement> getDepartement(Long id){
        return this.depRepo.findById(id);
    }
}
