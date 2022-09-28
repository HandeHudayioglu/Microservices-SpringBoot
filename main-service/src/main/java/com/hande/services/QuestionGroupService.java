package com.hande.services;


import com.hande.repository.QuestionGroupRepository;
import com.hande.repository.entity.QuestionGroup;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionGroupService extends ServiceManager<QuestionGroup,Long> {

    private final QuestionGroupRepository questionGroupRepository;

    public QuestionGroupService(QuestionGroupRepository questionGroupRepository) {
        super(questionGroupRepository);
        this.questionGroupRepository=questionGroupRepository;
    }
}
