package com.hande.mapper;

import com.hande.dto.request.EditProfileRequestDto;
import com.hande.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserProfileMapper {

    //dto dan class a class tan dto ya çevirme işlemini mapper yapıyor
    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile toUserProfile(final EditProfileRequestDto dto);
}
