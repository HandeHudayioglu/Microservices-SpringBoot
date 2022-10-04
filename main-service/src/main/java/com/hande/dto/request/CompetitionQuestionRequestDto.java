package com.hande.dto.request;

import lombok.Data;

@Data
public class CompetitionQuestionRequestDto {

   private String token;
   Long questionId;
   Long competitionId;
   Long period;
   int numOfSequence;
}
