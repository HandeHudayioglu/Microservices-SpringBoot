package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "question_table")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    Long id;
    @Column(length = 1000)
    String question;
    int duration;
    Long questionerId;
    int numOfAnswer;
    String groupName;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.WAITING;
    @Embedded
    TableAdd tableAdd;
}


//@OneToOne(mappedBy = "question")
//Answer answer;
//@ManyToOne
//@JoinColumn(name = "question_user", referencedColumnName = "user_id")
//User questionUser;
//@ManyToOne
//@JoinColumn(name = "competition", referencedColumnName = "id")
//Competition competition;
