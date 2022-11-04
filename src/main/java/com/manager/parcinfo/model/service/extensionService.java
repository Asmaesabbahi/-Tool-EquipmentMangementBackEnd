package com.manager.parcinfo.model.service;

import com.manager.parcinfo.model.bo.Departement;
import com.manager.parcinfo.model.bo.Extension;
import com.manager.parcinfo.model.dao.extensionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class extensionService {
    private final extensionRepo extensionrepo;

    @Autowired
    public extensionService(extensionRepo extensionrepo) {
        this.extensionrepo = extensionrepo;
    }

    public Extension addExtension(Extension extension){ return this.extensionrepo.save(extension); }

    public List<Extension> findAllExtension() { return this.extensionrepo.findAll();}

    public Extension updateExtension(Extension extension){ return this.extensionrepo.save(extension); }

    public void deleteExtension(Long id) { this.extensionrepo.deleteById(id);}

    public Optional<Extension> getExtension(Long id) { return this.extensionrepo.findById(id); }

    public Extension addDeptoExtension(Extension extension, Departement departement){
        List<Departement> deps = new ArrayList<>();
        deps.add(departement);
        extension.setDepartments(deps);
        return this.extensionrepo.save(extension);}
}
