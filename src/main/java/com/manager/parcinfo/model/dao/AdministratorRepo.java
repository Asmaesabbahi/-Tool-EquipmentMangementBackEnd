package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdministratorRepo extends JpaRepository<Administrator,Long> {
    //void deleteAdminById(Long Aid);
}
