package com.hande.repository.entity;


import com.hande.repository.enums.State;
import com.hande.repository.enums.StateOfCompetition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "competition_table")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long competitorId;
    String competitionTitle;
    String competitionDefinition;
    String photograph;
    int numOfWinner;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    StateOfCompetition stateOfCompetition = StateOfCompetition.OPENACTIVE;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.WAITING;
    @Embedded
    TableAdd tableAdd;
    @Transient
    List<Question> questionList;



}

   // @OneToOne
   // @JoinColumn(name = "answer", referencedColumnName = "answer")
   // Answer answer;
   // @OneToMany(mappedBy = "competition")
   // List<User>userList;
    //@OneToMany(mappedBy = "")
    //List<User>winnerList;
