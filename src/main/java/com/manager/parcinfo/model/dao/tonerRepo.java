package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Toner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tonerRepo extends JpaRepository<Toner,Long> {
}
