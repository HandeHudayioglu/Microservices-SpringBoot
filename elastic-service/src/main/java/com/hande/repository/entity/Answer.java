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
@Document(indexName = "answer")
public class Answer {

    @Id
    String uId;
    Long id;
    String answer;
    Long question_id;
    TableAdd tableAdd;
    boolean isTrue;
    @Builder.Default
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