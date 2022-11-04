package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Departement;
import com.manager.parcinfo.model.bo.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface extensionRepo extends JpaRepository<Extension,Long> {
    /*societeRepo societerepo = null;
    public Extension addExtension(Extension extension, societeRepo societerepo){
        extension.setCompany(societerepo.getById(extension.getCompany().getSid()));
        return this.save(extension);
    }*/
}
