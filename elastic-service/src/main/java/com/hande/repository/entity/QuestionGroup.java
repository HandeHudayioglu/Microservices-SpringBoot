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
@Document(indexName = "question_group")
public class QuestionGroup {

    @Id
    String uId;
    Long id;
    String nameOfGroup;
    State state;
    TableAdd tableAdd;

}
