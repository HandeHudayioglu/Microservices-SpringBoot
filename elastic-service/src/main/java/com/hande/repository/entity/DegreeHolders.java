package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "degree_holders")
public class DegreeHolders {
    @Id
    String uId;
    Long id;
    Long userId;
    Long competitionId;
    int score;
    int sequence;
    State state;
    TableAdd tableAdd;
}
