package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(indexName = "competition")
public class Competition {
   @Id
   String uId;
    Long id;

    Long competitorId;
    String competitionTitle;
    String competitionDefinition;
    String photograph;
    int numOfWinner;
    State state;
    TableAdd tableAdd;
    List<Question> questionList;



}

   // @OneToOne
   // @JoinColumn(name = "answer", referencedColumnName = "answer")
   // Answer answer;
   // @OneToMany(mappedBy = "competition")
   // List<User>userList;
    //@OneToMany(mappedBy = "")
    //List<User>winnerList;
