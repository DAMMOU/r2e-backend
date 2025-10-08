package com.r2e.r2e_backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User registration request payload")
public class RegisterRequest {

    @Schema(description = "User first name", example = "Youssef")
    private String firstName;

    @Schema(description = "User last name", example = "Dammou")
    private String lastName;

    @Schema(description = "User email address", example = "youssef@example.com")
    private String email;

    @Schema(description = "User password", example = "password123")
    private String password;

    @Schema(description = "Role assigned to the user (default: ROLE_USER)", example = "ROLE_USER")
    private String roleName = "ROLE_USER";

    @Schema(description = "Type of student (e.g., Undergraduate, Graduate, PhD)", example = "Graduate")
    private String studentType;

    @Schema(description = "Whether the user is subscribed to the newsletter", example = "true")
    private boolean newsletter;

    @Schema(description = "Whether the user has accepted the terms and conditions", example = "true")
    private boolean terms;
}
