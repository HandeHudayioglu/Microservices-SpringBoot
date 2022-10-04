package com.hande.services;


import com.hande.dto.request.CompetitionQuestionRequestDto;
import com.hande.mapper.ICompetitionQuestionMapper;
import com.hande.repository.CompetitionQuestionRepository;
import com.hande.repository.entity.CompetitionQuestion;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionQuestionService extends ServiceManager<CompetitionQuestion,Long> {

    private final CompetitionQuestionRepository competitionQuestionRepository;


    public CompetitionQuestionService(CompetitionQuestionRepository competitionQuestionRepository) {
       super(competitionQuestionRepository);
       this.competitionQuestionRepository=competitionQuestionRepository;
    }

    public CompetitionQuestion save(CompetitionQuestionRequestDto dto){
        return save(ICompetitionQuestionMapper.INSTANCE.toCompetition(dto));
    }
}
