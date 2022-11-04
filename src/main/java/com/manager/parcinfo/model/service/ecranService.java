package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Ecran;
import com.manager.parcinfo.model.dao.ecranRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ecranService {
    private final ecranRepo ecranrepo;

    @Autowired
    public ecranService(ecranRepo ecranrepo) { this.ecranrepo = ecranrepo; }

    public Ecran addEcran(Ecran ecran){ return this.ecranrepo.save(ecran); }

    public List<Ecran> findAllEcrans(){
        return this.ecranrepo.findAll();
    }

    public Ecran updateEcran(Ecran ecran){
        return this.ecranrepo.save(ecran);
    }

    public void deleteEcran(Long id){
        this.ecranrepo.deleteById(id);
    }

    public Optional<Ecran> getEcran(Long id){
        return this.ecranrepo.findById(id);
    }
}
