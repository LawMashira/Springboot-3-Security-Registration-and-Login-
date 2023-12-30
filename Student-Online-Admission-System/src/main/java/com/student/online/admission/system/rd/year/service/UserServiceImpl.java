package com.student.online.admission.system.rd.year.service;

import com.student.online.admission.system.rd.year.entity.Role;
import com.student.online.admission.system.rd.year.entity.User;
import com.student.online.admission.system.rd.year.exception.UserAlreadyExistsException;
import com.student.online.admission.system.rd.year.exception.UserNotFoundException;
import com.student.online.admission.system.rd.year.repository.RoleRepository;
import com.student.online.admission.system.rd.year.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

/*
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {

        if(userRepository.existsByEmail(user.getEmail())){
          throw new UserAlreadyExistsException(user.getEmail() + "already exists ")  ;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Transactional
    @Override
    public void deleteUser(String email) {
        User theUser = getUser(email);
        if(theUser!=null){
            userRepository.deleteByEmail(email);
        }

    }

    @Override
    public User getUser(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("User not  found exception"));
    }*/


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(String email) {
        User theUser = getUser(email);
        if (theUser != null){
            userRepository.deleteByEmail(email);
        }

    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
