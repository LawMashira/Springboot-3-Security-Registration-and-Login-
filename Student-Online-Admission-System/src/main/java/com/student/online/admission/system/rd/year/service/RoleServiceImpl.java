package com.student.online.admission.system.rd.year.service;

import com.student.online.admission.system.rd.year.entity.Role;
import com.student.online.admission.system.rd.year.entity.User;
import com.student.online.admission.system.rd.year.exception.RoleAlreadyExistException;
import com.student.online.admission.system.rd.year.exception.UserAlreadyExistsException;
import com.student.online.admission.system.rd.year.exception.UserNotFoundException;
import com.student.online.admission.system.rd.year.repository.RoleRepository;
import com.student.online.admission.system.rd.year.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl  implements  RoleService{
/*
    private final RoleRepository roleRepository;
    //private  final UserService userService;
    private  final  UserRepository userRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role theRole) {
        String roleName= "ROLE_"+ theRole.getName().toUpperCase();
        Role role = new Role(roleName);
        if(roleRepository.existsByName( roleName)){
            throw  new RoleAlreadyExistException(theRole.getName() + " role already exist");
        }
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        this.removeAllUsersFromRole(roleId);
roleRepository.deleteById(roleId);
    }

    @Override
    public Role findByName(String name) {

        return roleRepository.findByName(name).get();

    }

    @Override
    public User removeUserFromRole(Long userId, Long roleId) {
       Optional<User> user = userRepository.findById(userId);
       Optional<Role>  role= roleRepository.findById(roleId);
        if(role.isPresent()&&role.get().getUsers().contains(user.get())){
            role.get().removeUserFromRole(user.get());
            roleRepository.save(role.get());
            return user.get();
        }
        throw  new UserNotFoundException("User Not Found");
    }

    @Override
    public User assignRoleToUser(Long userId, Long roleId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Role>  role= roleRepository.findById(roleId);
        if(user.isPresent()&& user.get().getRoles().contains(role.get())) {
            throw new UserAlreadyExistsException(user.get().getFirstName()+ "is already assigned to the " + role.get().getName() + " role ");
        }
       if(role.isPresent()){
           role.get().assignRoleToUser(user.get());
           roleRepository.save(role.get());
       }
       return user.get();
    }

    @Override
    public Role removeAllUsersFromRole(Long roleId) {
Optional<Role> role = roleRepository.findById(roleId);
role.get().removeAllUsersFromRole();

        return roleRepository.save(role.get());
    }*/

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role theRole) {
        String roleName = "ROLE_"+theRole.getName().toUpperCase();
        Role role = new Role(roleName);
        if (roleRepository.existsByName(roleName)){
            throw new RoleAlreadyExistException(theRole.getName()+" role already exists");
        }
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        this.removeAllUsersFromRole(roleId);
        roleRepository.deleteById(roleId);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).get();
    }

    @Override
    public User removeUserFromRole(Long userId, Long roleId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Role>  role = roleRepository.findById(roleId);
        if (role.isPresent() && role.get().getUsers().contains(user.get())){
            role.get().removeUserFromRole(user.get());
            roleRepository.save(role.get());
            return user.get();
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public User assignRoleToUser(Long userId, Long roleId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Role>  role = roleRepository.findById(roleId);
        if (user.isPresent() && user.get().getRoles().contains(role.get())){
            throw new UserAlreadyExistsException(
                    user.get().getFirstName()+ " is already assigned to the" + role.get().getName()+ " role");
        }
        if (role.isPresent()){
            role.get().assignRoleToUser(user.get());
            roleRepository.save(role.get());
        }
        return user.get();
    }

    @Override
    public Role removeAllUsersFromRole(Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        role.ifPresent(Role::removeAllUsersFromRole);
        return roleRepository.save(role.get());
    }
}
