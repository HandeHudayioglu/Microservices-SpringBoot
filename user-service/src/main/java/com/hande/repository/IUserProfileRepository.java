package com.hande.repository;


import com.hande.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface IUserProfileRepository extends MongoRepository<UserProfile,Long> {

    @Query("select COUNT(a)>0 from UserProfile a where a.authId = ?1")
    Boolean isExist(Long authId);

    Optional<UserProfile>findOptionalByAuthId(Long authId);

}
