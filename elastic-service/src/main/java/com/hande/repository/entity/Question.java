package com.hande.repository.entity;


import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {

    @Id
    String uId;
    Long id;

    String question;
    int duration;
    Long questionerId;
    int numOfAnswer;
    String groupName;

    @Builder.Default
    State state;

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
