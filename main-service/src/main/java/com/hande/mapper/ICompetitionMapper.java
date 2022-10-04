package com.hande.mapper;

import com.hande.dto.request.CompetitionRequestDto;
import com.hande.repository.entity.Competition;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionMapper {

    ICompetitionMapper INSTANCE = Mappers.getMapper(ICompetitionMapper.class);


    Competition toCompetition(CompetitionRequestDto dto);
}
