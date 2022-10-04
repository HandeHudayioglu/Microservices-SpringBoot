package com.hande.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class CompetitionRequestDto {
    @NotNull
    Long competitorId;
    @NotNull
    String competitionTitle;
    @NotNull
    String competitionDefinition;
    @NotNull
    String photograph;
    @NotNull
    int numOfWinner;

    String token;
}
