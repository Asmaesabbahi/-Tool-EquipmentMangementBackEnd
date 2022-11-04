package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Societe;
import com.manager.parcinfo.model.dao.societeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class societeService {

    private final societeRepo societerepo;

    @Autowired
    public societeService(societeRepo societerepo) { this.societerepo = societerepo; }

    public Societe addSociete(Societe societe){ return this.societerepo.save(societe); }

    public List<Societe> findAllSociete() {return this.societerepo.findAll();}

    public Societe updateSociete(Societe societe){ return this.societerepo.save(societe); }

    public void deleteSociete(Long id) { this.societerepo.deleteById(id);}

    public Optional<Societe> getSociete(Long id) { return this.societerepo.findById(id);}
}
