package com.hande.graphql.query;

import com.hande.repository.entity.UserProfile;
import com.hande.service.UserProfileService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserProfileQueryResolver implements GraphQLQueryResolver {

    private final UserProfileService userProfileService;

    public Iterable<UserProfile> findAll(){
        return userProfileService.findTop1000();
    }
    public List<UserProfile> findAllByUserName(String userName){
        return userProfileService.findAllByUserName(userName);
    }

    public List<String> bulBakalimBunlariEmailListesiniGetir(){
        return userProfileService.findAllEmailList();
    }
}
