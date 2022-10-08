package com.hande.service;

import com.hande.dto.request.EditProfileRequestDto;
import com.hande.dto.request.NewUserCreateDto;
import com.hande.mapper.IUserProfileMapper;
import com.hande.repository.IUserProfileRepository;
import com.hande.repository.entity.UserProfile;
import com.hande.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final IUserProfileRepository userProfileRepository;
    @Autowired
    private CacheManager cacheManager;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserProfile(NewUserCreateDto dto) {

        return save(UserProfile.builder()
                .authId(dto.getAuthId())
                .userName(dto.getUserName())
                .email(dto.getEmail()).build());
    }

    public Boolean updateUserProfile(EditProfileRequestDto dto, Long authId) {

        //controllerdan gelen dto yu userprofile a çevirdik mapper sayesinde
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(dto);
        Optional<UserProfile> optionalUserProfile= userProfileRepository.findOptionalByAuthId(authId);
        if(optionalUserProfile.isEmpty())  return  false;

        try {
            userProfile.setId(optionalUserProfile.get().getId());
            update(userProfile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Page<UserProfile> findAllPage(int currentPage, int pageSize, String sortParameter,String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable pageable = PageRequest.of(currentPage, pageSize,sort);
        return userProfileRepository.findAll(pageable);
    }
    public Slice<UserProfile> findAllSlice(int currentPage,int pageSize,String sortParameter,String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return userProfileRepository.findAll(pageable);
    }
    public void clearCache(String key,String parameter){
        cacheManager.getCache(key).evict(parameter);
    }
    //[method adı]::[değer]  -> id
    @Cacheable(value = "userprofile_getall")
    public List<UserProfile> getAllCache() {

        return userProfileRepository.findAll();
    }
}