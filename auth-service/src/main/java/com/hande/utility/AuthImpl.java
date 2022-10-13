package com.hande.utility;

import com.hande.dto.request.RegisterRequestDto;
import com.hande.repository.enums.Roles;
import com.hande.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class AuthImpl {

    private final AuthService authService;

    //@PostConstruct
    public void init(){
        authService.register(RegisterRequestDto.builder()
                        .userName("admin")
                        .email("admin@admin.com")
                        .password("123456")
                        .role(Roles.ADMIN)
                        .RoleAdminPassword("123456")
                .build());

        authService.register(RegisterRequestDto.builder()
                .userName("deniz")
                .email("deniz@admin.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());

        authService.register(RegisterRequestDto.builder()
                .userName("eda")
                .email("eda@eda.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());

        authService.register(RegisterRequestDto.builder()
                .userName("ekrem")
                .email("ekrem@ekrem.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());

        authService.register(RegisterRequestDto.builder()
                .userName("can")
                .email("can@can.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());


        authService.register(RegisterRequestDto.builder()
                .userName("bilge")
                .email("bilge@bilge.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());


        authService.register(RegisterRequestDto.builder()
                .userName("kevser")
                .email("kevser@kevser.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());


        authService.register(RegisterRequestDto.builder()
                .userName("ahmet")
                .email("ahmet@ahmet.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());


        authService.register(RegisterRequestDto.builder()
                .userName("hande")
                .email("hande@hande.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());

        authService.register(RegisterRequestDto.builder()
                .userName("hakan")
                .email("hakan@hakan.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());

        authService.register(RegisterRequestDto.builder()
                .userName("merve")
                .email("merve@merve.com")
                .password("123456")
                .role(Roles.USER)
                .RoleAdminPassword("123456")
                .build());




    }
}
