package com.student.online.admission.system.rd.year.security.user;

import com.student.online.admission.system.rd.year.entity.User;
import com.student.online.admission.system.rd.year.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentUserDetailsService implements UserDetailsService
{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
                 return StudentUserDetails.buildUserDetails(user);



    }
}
