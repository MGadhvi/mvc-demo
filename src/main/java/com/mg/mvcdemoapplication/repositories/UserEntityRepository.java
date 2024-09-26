package com.mg.mvcdemoapplication.repositories;

import com.mg.mvcdemoapplication.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> getUserEntityById(Integer id);

    List<UserEntity> getUserEntityByName(String name);
}