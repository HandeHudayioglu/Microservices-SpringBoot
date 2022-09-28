package com.hande.repository;


import com.hande.repository.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserProfileRepository extends JpaRepository<UserProfile,Long> {

    @Query("select COUNT(a)>0 from UserProfile a where a.authId = ?1")
    Boolean isExist(Long authId);

    Optional<UserProfile>findOptionalByAuthId(Long authId);

}
