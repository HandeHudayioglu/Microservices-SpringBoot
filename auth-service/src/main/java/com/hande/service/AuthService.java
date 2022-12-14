package com.hande.service;

import com.hande.dto.request.DoLoginRequestDto;
import com.hande.dto.request.NewUserCreateDto;
import com.hande.dto.request.RegisterRequestDto;
import com.hande.manager.IUserManager;
import com.hande.rabbitmq.model.CreateUser;
import com.hande.rabbitmq.producer.CreateUserProducer;
import com.hande.repository.IAuthRepository;
import com.hande.repository.entity.Auth;
import com.hande.repository.enums.Roles;
import com.hande.utility.ServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository authRepository;

    private final IUserManager userManager;

    private final CreateUserProducer createUserProducer;

    public AuthService(IAuthRepository authRepository,IUserManager userManager,CreateUserProducer createUserProducer) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager=userManager;
        this.createUserProducer=createUserProducer;
    }

    public Optional<Auth> doLogin(DoLoginRequestDto dto){
      return authRepository.findOptionalByUserNameIgnoreCaseAndPassword(dto.getUserName(), dto.getPassword());
    }

    public Auth register(RegisterRequestDto dto){
        Auth auth ;
            auth=Auth.builder()
                    .password(dto.getPassword())
                    .userName(dto.getUserName())
                    .role(Roles.USER)
                    .build();
            if(dto.getRoleAdminPassword()!=null)
                if(dto.getRoleAdminPassword().equals("123456"))
                    auth.setRole(dto.getRole()==null ? Roles.ADMIN:dto.getRole());
            else
                auth.setRole(Roles.USER);

         save(auth);
         /*
         User service e kullanıcının profilin oluşması için istek gönder
         userManager.NewUserCreate(
                 NewUserCreateDto.builder()
                         .authId(auth.getId())
                         .email(dto.getEmail())
                         .userName(dto.getUserName()).build()

         );
         */

         /* */
         createUserProducer.sendCreateUserMessage(CreateUser.builder()
                         .authId(auth.getId())
                         .email(dto.getEmail())
                         .userName(dto.getUserName())
                         .password(dto.getPassword())
                         .build());
         return auth;


    }
}
