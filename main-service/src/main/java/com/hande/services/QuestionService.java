package com.hande.services;


import com.hande.dto.request.AddQuestionRequestDto;
import com.hande.repository.QuestionRepository;
import com.hande.repository.entity.Question;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends ServiceManager<Question,Long> {

    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository,AnswerService answerService) {
        super(questionRepository);
        this.questionRepository=questionRepository;
        this.answerService=answerService;
    }

    public void addQuestion(AddQuestionRequestDto dto){
        /**
         * Soruyu kayıt ediyor.
         */
        Question question= save(Question.builder()
                .question(dto.getQuestion().getQuestionDetail())
                .numOfAnswer(dto.getQuestion().getNumOfAnswer())
                .duration(dto.getQuestion().getDuration())
                        .questionerId(dto.getQuestion().getCreatorId())
                        .build());

        /**
         * cevapları kayıt etmeniz gerekli.
         * 1. cevap kayıt edebnilmeniz için soru idsine ihtiyaç var
         * 2. bir sorunun en az 2 cevabı(şıkkı) olmalı
         */
        answerService.addQuestionAnwers(dto.getAnswers(), question.getId());
    }
}
