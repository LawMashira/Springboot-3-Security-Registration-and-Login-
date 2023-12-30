package com.student.online.admission.system.rd.year.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private  String email;
    @NotBlank
    private  String password;
}
