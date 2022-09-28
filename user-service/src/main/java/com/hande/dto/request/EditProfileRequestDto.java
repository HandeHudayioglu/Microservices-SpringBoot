package com.hande.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EditProfileRequestDto {

    String token;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String photo;
    String address;
    String about;
}
