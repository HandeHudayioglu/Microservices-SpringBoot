package com.hande.services;


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
}
