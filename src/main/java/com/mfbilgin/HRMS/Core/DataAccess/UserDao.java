package com.mfbilgin.HRMS.Core.DataAccess;

import com.mfbilgin.HRMS.Core.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getByEmail(String email);
}
