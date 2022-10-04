package com.hande.controller;

import com.hande.dto.request.CompetitionQuestionRequestDto;
import com.hande.exception.ErrorType;
import com.hande.exception.MainManagerException;
import com.hande.repository.entity.CompetitionQuestion;
import com.hande.services.CompetitionQuestionService;
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
@RequestMapping(BASE_URL + MAIN+ COMPETITION_QUESTION)
@RequiredArgsConstructor
public class CompetitionQuestionController {

    private final CompetitionQuestionService competitionQuestionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Void> createCompetitionQuestion(@RequestBody @Valid CompetitionQuestionRequestDto dto){
        try{
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty())  throw new MainManagerException(ErrorType.INVALID_TOKEN);
            competitionQuestionService.save(dto);

            return ResponseEntity.ok().build();

        } catch( Exception e) {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }



}
