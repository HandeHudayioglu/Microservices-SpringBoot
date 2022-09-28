package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "degree_holders_table")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DegreeHolders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long competitionId;
    int score;
    int sequence;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    TableAdd tableAdd;
}
