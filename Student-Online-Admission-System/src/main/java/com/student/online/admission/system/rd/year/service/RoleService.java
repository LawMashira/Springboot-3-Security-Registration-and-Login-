package com.student.online.admission.system.rd.year.service;

import com.student.online.admission.system.rd.year.entity.Role;
import com.student.online.admission.system.rd.year.entity.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {
/*
    List<Role> getRoles();
    Role createRole(Role  theRole);
    void  deleteRole(Long id);
    Role findByName(String name);
  User removeUserFromRole(Long userId, Long roleId);

    User assignRoleToUser(Long userId,Long roleId);
    Role removeAllUsersFromRole (Long roleId);*/


    List<Role> getRoles();
    Role createRole(Role theRole);

    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);
    User assignRoleToUser(Long userId, Long roleId);
    Role removeAllUsersFromRole(Long roleId);


}
