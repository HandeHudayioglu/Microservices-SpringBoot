package com.hande.dto.request;
import com.hande.repository.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RegisterRequestDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Username must be a minimum of 3 characters and a maximum of 20 characters")
    String userName;
    @NotNull
    String password;
    @NotNull
    @Email(message = "Email format is not suitable")
    String email;
    Roles role;
    String RoleAdminPassword;
}
