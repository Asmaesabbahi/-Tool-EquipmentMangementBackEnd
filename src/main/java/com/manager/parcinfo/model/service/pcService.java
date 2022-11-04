package com.manager.parcinfo.model.service;


import com.manager.parcinfo.model.bo.Pc;
import com.manager.parcinfo.model.dao.pcRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class pcService {
    private final pcRepo pcRepo;

    @Autowired
    public pcService(com.manager.parcinfo.model.dao.pcRepo pcRepo) { this.pcRepo = pcRepo; }

    public Pc addPc(Pc pc){
        return this.pcRepo.save(pc);
    }

    public List<Pc> findAllPcs(){
        return this.pcRepo.findAll();
    }

    public Pc updatePc(Pc pc){
        return this.pcRepo.save(pc);
    }

    public void deletePc(Long id){
        this.pcRepo.deleteById(id);
    }

    public Optional<Pc> getPc(Long id){
        return this.pcRepo.findById(id);
    }
}
