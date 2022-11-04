package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface societeRepo extends JpaRepository<Societe,Long> {
}
