package com.hande.controller;

import com.hande.dto.request.CompetitionRequestDto;
import com.hande.exception.ErrorType;
import com.hande.exception.MainManagerException;
import com.hande.repository.entity.Competition;
import com.hande.services.CompetitionService;
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
@RequestMapping(BASE_URL + MAIN + COMPETITION)
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;
    private final JwtTokenManager jwtTokenManager;
    @PostMapping(CREATE)
    public ResponseEntity<Competition> createCompetition (@RequestBody @Valid CompetitionRequestDto dto){
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty())   throw new MainManagerException(ErrorType.INVALID_TOKEN);
            return  ResponseEntity.ok(competitionService.save(dto));

        } catch(Exception e) {

            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }

    }
}
