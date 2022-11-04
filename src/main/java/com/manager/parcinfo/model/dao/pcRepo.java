package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Pc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pcRepo extends JpaRepository<Pc,Long> {
}
