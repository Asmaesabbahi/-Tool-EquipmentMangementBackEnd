package com.manager.parcinfo.model.dao;

import com.manager.parcinfo.model.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Long> {
}
