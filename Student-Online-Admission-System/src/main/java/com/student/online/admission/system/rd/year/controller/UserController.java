package com.student.online.admission.system.rd.year.controller;

import com.student.online.admission.system.rd.year.entity.User;
import com.student.online.admission.system.rd.year.exception.UserNotFoundException;
import com.student.online.admission.system.rd.year.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
   /* @Autowired
    private final UserService userService;
@GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);


    }
@GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
        try {
        User theUser= userService.getUser(email);
        return  ResponseEntity.ok(theUser);

        } catch (UserNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
          return   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in fetching the user");
        }
    }
    @DeleteMapping("/delete/{userId}")
    public  ResponseEntity <String> deleteUser(@PathVariable("userId") String email){
       try {
           userService.deleteUser(email);
           return ResponseEntity.ok("User deleted ");
       }catch (UserNotFoundException e){
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }catch ( Exception e ){
           return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in deleting the user");
       }

    }
    */
    //********************************************************************
    private final UserService userService;

    @GetMapping("/all")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getUsers(){

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.FOUND);
    }

    @GetMapping("/{email}")
   // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email){
        try{
            User theUser = userService.getUser(email);
            return ResponseEntity.ok(theUser);
        }catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching user");
        }
    }
    @DeleteMapping("/delete/{userId}")
    //@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #email == principal.username)")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String email){
        try{
            userService.deleteUser(email);
            return ResponseEntity.ok("User deleted successfully");
        }catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user: " + e.getMessage());
        }
    }
}