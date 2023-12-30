package com.student.online.admission.system.rd.year.repository;

import com.student.online.admission.system.rd.year.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {
   /* boolean existsByEmail(String email);

    void deleteByEmail(String email);

   Optional < User > findByEmail(String email);*/
   boolean existsByEmail(String email);

    void deleteByEmail(String email);

    Optional<User> findByEmail(String email);
}
