package com.r2e.r2e_backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Login request payload")
public class LoginRequest {

    @Schema(description = "User email", example = "youssef@example.com")
    private String email;

    @Schema(description = "User password", example = "password123")
    private String password;
}
