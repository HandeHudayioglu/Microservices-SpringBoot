package com.hande.service;

import com.hande.repository.IAuthRepository;
import com.hande.repository.entity.Auth;
import com.hande.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }
}
