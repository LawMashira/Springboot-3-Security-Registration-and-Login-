package com.student.online.admission.system.rd.year.security;

import com.student.online.admission.system.rd.year.security.jwt.AuthTokenFilter;
import com.student.online.admission.system.rd.year.security.jwt.JwtAuthEntryPoint;
import com.student.online.admission.system.rd.year.security.user.StudentUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @Author Lawson Matutu
Zimbabwe Open University 3rd Year Project
 **/
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class WebSecurityConfig
{
/*
    private  final StudentUserDetailsService userDetailService;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;
    @Bean
    public AuthTokenFilter authTokenFilter(){
        return  new AuthTokenFilter();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean

    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    @Bean
 public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
 }
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception-> exception.authenticationEntryPoint(jwtAuthEntryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeRequests(auth->auth
                        .requestMatchers("/auth/**")
                        .permitAll().requestMatchers("/roles/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();

 }
 */
    //===================================================================
    private final StudentUserDetailsService userDetailsService;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public AuthTokenFilter authenticationTokenFilter(){
        return new AuthTokenFilter();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer :: disable)
                .exceptionHandling(
                        exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**")
                        .permitAll().requestMatchers("/roles/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }



}
