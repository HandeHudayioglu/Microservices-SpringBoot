package com.hande.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionRequestDto {

    private String questionDetail;
    private int duration;
    private long creatorId;
    private int numOfAnswer;
    private String token;
}
