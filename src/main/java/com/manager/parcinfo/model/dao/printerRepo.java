package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface printerRepo extends JpaRepository<Printer,Long> {
}
