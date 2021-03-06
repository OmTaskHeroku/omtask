package com.example.omtask.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Role findByName(String name);
}
