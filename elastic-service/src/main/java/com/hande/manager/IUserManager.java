package com.hande.manager;

import com.hande.repository.entity.UserProfile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${raceapplication.url.user}v1/api/user", name = "user-service-userprofile", decode404 = true)
public interface IUserManager {

    @GetMapping("/findall")
    ResponseEntity<List<UserProfile>> findAll();
}
