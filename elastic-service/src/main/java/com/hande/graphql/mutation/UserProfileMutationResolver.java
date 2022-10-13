package com.hande.graphql.mutation;


import com.hande.graphql.model.UserProfileInput;
import com.hande.repository.entity.UserProfile;
import com.hande.service.UserProfileService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver {

    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput profile){
        userProfileService.save(UserProfile.builder()
                        .id(456_90L)
                        .authId(profile.getAuthId())
                        .userName(profile.getUserName())
                        .firstName(profile.getFirstName())
                        .lastName(profile.getLastName())
                        .email(profile.getEmail())
                        .build());
        return true;

    }
}
