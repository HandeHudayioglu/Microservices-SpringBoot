package com.hande.services;


import com.hande.repository.CompetitionRepository;
import com.hande.repository.entity.Competition;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService extends ServiceManager<Competition,Long> {

    private final CompetitionRepository competitionRepository;


    public CompetitionService(CompetitionRepository competitionRepository) {
        super(competitionRepository);
        this.competitionRepository=competitionRepository;
    }
}
