package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departementRepo extends JpaRepository<Departement,Long> {
}
