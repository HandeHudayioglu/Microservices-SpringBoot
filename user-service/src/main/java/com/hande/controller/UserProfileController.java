package com.hande.controller;

import com.hande.dto.request.EditProfileRequestDto;
import com.hande.dto.request.NewUserCreateDto;
import com.hande.exception.ErrorType;
import com.hande.exception.UserManagerException;
import com.hande.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.hande.constants.ApiUrls.*;
@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(NEW_CREATE_USER)
    public ResponseEntity<Boolean> NewUserCreate(@RequestBody @Valid NewUserCreateDto dto){
       try{
           userProfileService.createUserProfile(dto);
           return ResponseEntity.ok(true);
       } catch (Exception e) {

           throw new UserManagerException(ErrorType.USER_CANT_CREATE);
       }
    }

    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid EditProfileRequestDto dto){

          if(dto.getToken()==null)
              throw new UserManagerException(ErrorType.INVALID_TOKEN);
          try{
              Long authId = Long.parseLong(dto.getToken().substring(3,dto.getToken().indexOf("X")));

              return ResponseEntity.ok(userProfileService.updateUserProfile(dto,authId));

          } catch (Exception e){
              throw new UserManagerException(ErrorType.INVALID_TOKEN);
          }




    }
}
