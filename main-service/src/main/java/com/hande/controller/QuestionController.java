package com.hande.controller;

import com.hande.dto.request.AddQuestionRequestDto;
import com.hande.dto.request.QuestionRequestDto;
import com.hande.exception.ErrorType;
import com.hande.exception.MainManagerException;
import com.hande.services.QuestionService;
import com.hande.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static com.hande.constants.ApiUrls.*;
@RestController
@RequestMapping(BASE_URL + MAIN+ QUESTION)
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Void> createQuestion(@RequestBody @Valid AddQuestionRequestDto dto){
        try{
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty())  throw new MainManagerException(ErrorType.INVALID_TOKEN);
            questionService.addQuestion(dto);
            return ResponseEntity.ok().build();

        } catch( Exception e) {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
