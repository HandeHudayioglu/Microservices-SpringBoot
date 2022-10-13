package com.hande.utility;

import com.hande.manager.IUserManager;
import com.hande.repository.entity.UserProfile;
import com.hande.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllData {

    private final UserProfileService userProfileService;
    private final IUserManager userManager;

    @PostConstruct
    public void init(){
        List<UserProfile> lists = userManager.findAll().getBody().subList(1,400);
        userProfileService.saveAll(lists);
    }
}
