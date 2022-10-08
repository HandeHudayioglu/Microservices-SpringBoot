package com.hande.controller;

import com.hande.dto.request.DoLoginRequestDto;
import com.hande.dto.request.RegisterRequestDto;
import com.hande.repository.entity.Auth;
import com.hande.service.AuthService;
import com.hande.config.security.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static com.hande.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;



    //http://localhost:9999/v1/api/auth/test
    @GetMapping("/test")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public String getTestString(){
        return "Auth test";
    }

    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        Optional<Auth> auth = authService.doLogin(dto);
       if(auth.isPresent()) {
           String token = jwtTokenManager.createToken(auth.get().getId()).get();
           return ResponseEntity.ok(token);
       }
       return ResponseEntity.badRequest().body("Giris basarisiz");

    }
    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto){
        authService.register(dto);
        return ResponseEntity.ok().build();
    }

}
