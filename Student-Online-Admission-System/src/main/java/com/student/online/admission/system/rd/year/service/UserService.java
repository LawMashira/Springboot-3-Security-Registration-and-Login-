package com.student.online.admission.system.rd.year.service;

import com.student.online.admission.system.rd.year.entity.User;
import com.student.online.admission.system.rd.year.exception.UserAlreadyExistsException;
import com.student.online.admission.system.rd.year.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
     User  registerUser(User user) throws UserAlreadyExistsException;
     List<User> getUsers();

     void deleteUser (String email);
     User getUser(String email) throws UserNotFoundException;
}
