package com.hande.controller;

import com.hande.dto.request.QuestionGroupRequestDto;
import com.hande.exception.ErrorType;
import com.hande.exception.MainManagerException;
import com.hande.repository.entity.QuestionGroup;
import com.hande.services.QuestionGroupService;
import com.hande.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.hande.constants.ApiUrls.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL+MAIN+QUESTION_GROUP)
@RequiredArgsConstructor
public class QuestionGroupController {

    private final JwtTokenManager jwtTokenManager;
    private final QuestionGroupService questionGroupService;

    @PostMapping(CREATE)
    public ResponseEntity<QuestionGroup> createQuestionGroup(@RequestBody @Valid QuestionGroupRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            /**
            *Burada gelen userid nin ilgili işlemi yapabilecek yetkisinin olup olmadığı kontrol edilerek işleme
            *izin verilmelidir.
             */
            return ResponseEntity.ok(questionGroupService.save(QuestionGroup.builder()
                    .nameOfGroup(dto.getGroupName())
                    .build()));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
