package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "answer_table")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 1000)
    String answer;
    Long question_id;
    @Embedded
    TableAdd tableAdd;
    boolean isTrue;
    @Enumerated(EnumType.STRING)
   // @Builder.Default
    State state;

}

//@ManyToOne
//@JoinColumn(name = "answer_id", referencedColumnName = "user_id")
//User user;
//@OneToOne
//@JoinColumn (name = "competition", referencedColumnName = "id")
//Competition competition;
//@ManyToOne
//@JoinColumn(name = "answer_question", referencedColumnName = "user_id")
//User answerUser;
//@OneToOne
//@JoinColumn(name = "question", referencedColumnName = "question_id")
//Question question;