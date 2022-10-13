package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(indexName = "competition_ques")
public class CompetitionQuestion {
    @Id
    String uId;
    Long id;
    Long questionId;
    Long competitionId;
    Long period;
    int numOfSequence;
    State state;
    TableAdd tableAdd;


}
