package com.hande.repository.entity;
import com.hande.repository.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "question_group_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class QuestionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nameOfGroup;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    State state = State.APPROVED;
    @Embedded
    TableAdd tableAdd;

}
