package com.student.online.admission.system.rd.year.controller;


import com.student.online.admission.system.rd.year.controller.response.JwtResponse;
import com.student.online.admission.system.rd.year.entity.User;
import com.student.online.admission.system.rd.year.exception.UserAlreadyExistsException;
import com.student.online.admission.system.rd.year.request.LoginRequest;
import com.student.online.admission.system.rd.year.security.jwt.JwtUtils;
import com.student.online.admission.system.rd.year.security.user.StudentUserDetails;
import com.student.online.admission.system.rd.year.service.UserService;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    /*
    private   final UserService userService;
    private  final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(User user){
        try{

            userService.registerUser(user);
            return ResponseEntity.ok("Registration successful");
        }catch (UserAlreadyExistsException e){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public  ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        SecurityContextHolder .getContext().setAuthentication(authentication);
        String jwt =jwtUtils.generateJwtTokenForUser(authentication);
        StudentUserDetails userDetails= (StudentUserDetails) authentication.getPrincipal();
        List<String> roles =userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return ResponseEntity.ok(new JwtResponse(

                userDetails.getId(),
                userDetails.getEmail(),
                jwt,
                roles));


    }*/
    //0000000000000000000000000000000000000000000000000000
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{
            userService.registerUser(user);
            return ResponseEntity.ok("Registration successful!");

        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request){
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtTokenForUser(authentication);
        StudentUserDetails userDetails = (StudentUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();
        return ResponseEntity.ok(new JwtResponse(
                userDetails.getId(),
                userDetails.getEmail(),
                jwt,
                roles));
    }

}
