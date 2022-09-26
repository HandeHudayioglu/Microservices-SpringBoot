package com.hande.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DoLoginRequestDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Username must be a minimum of 3 characters and a maximum of 20 characters")
    String userName;
    @NotNull
    String password;
}
