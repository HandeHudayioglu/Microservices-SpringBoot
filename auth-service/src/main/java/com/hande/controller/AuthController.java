package com.hande.controller;

import com.hande.dto.request.DoLoginRequestDto;
import com.hande.dto.request.RegisterRequestDto;
import com.hande.repository.entity.Auth;
import com.hande.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static com.hande.constants.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        Optional<Auth> auth = authService.doLogin(dto);
       if(auth.isPresent()) {
           String token = "token: TKK" + auth.get().getId().toString() + "X06Y4";
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