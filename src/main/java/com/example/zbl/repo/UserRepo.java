package com.example.zbl.repo;

import com.example.zbl.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByName(String name);
    UserEntity getById(int in);
}
