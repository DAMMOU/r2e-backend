package com.r2e.r2e_backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Authentication response containing the JWT token")
public class JwtResponse {

    @Schema(
            description = "JWT authentication token",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    )
    private String token;

    @Schema(
            description = "Type of token",
            example = "Bearer",
            defaultValue = "Bearer"
    )
    private String type = "Bearer";

    @Schema(
            description = "User ID",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "User email address",
            example = "youssef.dammou@example.com"
    )
    private String email;

    @Schema(
            description = "User first name",
            example = "Youssef"
    )
    private String firstName;

    @Schema(
            description = "User last name",
            example = "Dammou"
    )
    private String lastName;

    @Schema(
            description = "User role",
            example = "ROLE_USER",
            allowableValues = {"ROLE_USER", "ROLE_ADMIN", "ROLE_STUDENT", "ROLE_PROFESSOR"}
    )
    private String role;

    // Constructor without token type (defaults to "Bearer")
    public JwtResponse(String token, Long id, String email, String firstName, String lastName, String role) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
