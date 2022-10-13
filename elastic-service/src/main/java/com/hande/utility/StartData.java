package com.hande.utility;

import com.hande.manager.IUserManager;
import com.hande.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StartData {
    @Autowired
    private IUserManager userManager;
    @Autowired
    private UserProfileService userProfileService;
    @PostConstruct
    public void init(){
        userProfileService.saveAll(userManager.findAll().getBody());
    }
}
