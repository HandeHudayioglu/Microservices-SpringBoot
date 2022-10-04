package com.hande.mapper;

import com.hande.dto.request.CompetitionQuestionRequestDto;
import com.hande.dto.request.CompetitionRequestDto;
import com.hande.repository.entity.Competition;
import com.hande.repository.entity.CompetitionQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionQuestionMapper {

    ICompetitionQuestionMapper INSTANCE = Mappers.getMapper(ICompetitionQuestionMapper.class);
    CompetitionQuestion toCompetition(CompetitionQuestionRequestDto dto);


}
