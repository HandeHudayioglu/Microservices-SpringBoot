package com.hande.service;

import com.hande.repository.IUserProfileRepository;
import com.hande.repository.entity.UserProfile;
import com.hande.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {


    private final IUserProfileRepository repository;

    public UserProfileService(IUserProfileRepository repository){
        super(repository);
        this.repository=repository;
    }

    public List<UserProfile> findAllByUserName(String userName){
        Pageable pageable = Pageable.ofSize(1000);
        return repository.findAllByUserName(userName,pageable);
    }

    public List<String> findAllEmailList(){
        return repository.findAllEmailList();
    }


    public List<UserProfile> findTop1000(){
        Pageable pageable = Pageable.ofSize(1000);
        return repository.findAll(pageable).getContent();
    }
}
