package com.karan.app.crud.Repo;

import com.karan.app.crud.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
