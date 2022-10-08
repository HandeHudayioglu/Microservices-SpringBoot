package com.hande.controller;

import com.hande.dto.request.EditProfileRequestDto;
import com.hande.dto.request.NewUserCreateDto;
import com.hande.exception.ErrorType;
import com.hande.exception.UserManagerException;
import com.hande.repository.entity.UserProfile;
import com.hande.service.UserProfileService;
import com.hande.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.hande.constants.ApiUrls.*;
@RestController
@RequestMapping(BASE_URL + USER)
@RequiredArgsConstructor
@Slf4j
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final JwtTokenManager jwtTokenManager;

    Logger log = Logger.getLogger(UserProfileController.class.getName());

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
          try{
             // Long authId = Long.parseLong(dto.getToken().substring(3,dto.getToken().indexOf("X")));
              Optional<Long> authId = jwtTokenManager.getUserId(dto.getToken());
              if(authId.isEmpty()) throw new UserManagerException(ErrorType.INVALID_TOKEN);
              return ResponseEntity.ok(userProfileService.updateUserProfile(dto,authId.get()));
          } catch (Exception e){
              throw new UserManagerException(ErrorType.INVALID_TOKEN);
          }
    }
    @GetMapping(FINDALL)
    public ResponseEntity<Page<UserProfile>>findAll(int currentPage, int pageSize, String sortParameter,String direction){
        return ResponseEntity.ok(userProfileService.findAllPage(currentPage, pageSize,sortParameter,direction));
    }
    @GetMapping(FINDALL_SLICE)
    public ResponseEntity<Slice<UserProfile>>findAllSlice(int currentPage, int pageSize, String sortParameter, String direction){
        return ResponseEntity.ok(userProfileService.findAllSlice(currentPage, pageSize,sortParameter,direction));
    }
    @GetMapping("/findallcriteria/{page}/{size}/{sortparameter}/{direction}")
    public ResponseEntity<Slice<UserProfile>> findAllCriteria(@PathVariable int page,
                                                              @PathVariable int size,
                                                              @PathVariable String sortparameter,
                                                              @PathVariable String direction){
        return ResponseEntity.ok(userProfileService.findAllSlice(page, size,sortparameter,direction));
    }
    @GetMapping("/redis")
    @Cacheable(value = "hello_redis")
    public String helloRedis(String message){
        try {
            Thread.sleep(3000);
            return "Mesajınız...." +message;
        } catch(Exception e){
            log.error("Hata "+e.getMessage());
            return "HATA";
        }
    }

    @GetMapping("/getall")
    public List<UserProfile> getAll(){
       log.info("Tüm kullanıcılar getirildi");
        return userProfileService.getAllCache();
    }

    @GetMapping("clearcache")
    public void clearCache(String key,String parameter){
        userProfileService.clearCache(key,parameter);
    }
}
