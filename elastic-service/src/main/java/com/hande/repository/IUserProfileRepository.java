package com.hande.repository;


import com.hande.repository.entity.UserProfile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@EnableElasticsearchRepositories
public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile,Long> {

    //@Query("select COUNT(a)>0 from UserProfile a where a.authId = ?1")
    //Boolean isExist(Long authId);

    //Optional<UserProfile>findOptionalByAuthId(Long authId);

    List<UserProfile> findAllByUserName(String userName, Pageable pageable);
    @Query("select u.email from UserProfile u")
    List<String> findAllEmailList();



}
