package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "competition_question_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompetitionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long questionId;
    Long competitionId;
    Long period;
    int numOfSequence;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    TableAdd tableAdd;


}
