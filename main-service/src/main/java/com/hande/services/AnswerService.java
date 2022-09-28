package com.hande.services;


import com.hande.dto.request.AnswersRequestDto;
import com.hande.repository.AnswerRepository;
import com.hande.repository.entity.Answer;
import com.hande.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService extends ServiceManager<Answer,Long> {

    private final AnswerRepository answerRepository;


    public AnswerService(AnswerRepository answerRepository) {
        super(answerRepository);
        this.answerRepository=answerRepository;
    }

    public void addQuestionAnwers(List<AnswersRequestDto> dto, Long questionId){ //soruya verilen cevapları ekle
        dto.forEach(answer->{
            save(Answer.builder()
                    .question_id(questionId)
                    .isTrue(answer.isTrueAnswer())
                    .answer(answer.getAnswerDetail())
                    .build());
        });
    }
}
