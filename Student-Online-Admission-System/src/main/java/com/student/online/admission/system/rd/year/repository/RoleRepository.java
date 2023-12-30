package com.student.online.admission.system.rd.year.repository;

import com.student.online.admission.system.rd.year.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role,Long> {
/*
    Optional<Role> findByName(String role);

    boolean existsByName(Role role);


    */

    Optional<Role> findByName(String role);


    boolean existsByName(String role);
}
