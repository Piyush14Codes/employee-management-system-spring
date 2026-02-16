package com.ems.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ems.employee_management_system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
