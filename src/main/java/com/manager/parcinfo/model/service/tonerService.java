package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Toner;
import com.manager.parcinfo.model.dao.AdministratorRepo;
import com.manager.parcinfo.model.dao.tonerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class tonerService {
    private final tonerRepo tonerrepo;

    @Autowired
    public tonerService(tonerRepo tonerrepo) { this.tonerrepo = tonerrepo; }

    public Toner addToner(Toner toner){ return this.tonerrepo.save(toner); }

    public List<Toner> findAllToners(){
        return this.tonerrepo.findAll();
    }

    public Toner updateToner(Toner toner){
        return this.tonerrepo.save(toner);
    }

    public void deleteToner(Long id){ this.tonerrepo.deleteById(id); }

    public Optional<Toner> getToner(Long id){
        return this.tonerrepo.findById(id);
    }

}
