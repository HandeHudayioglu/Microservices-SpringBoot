package com.hande.repository;


import com.hande.repository.entity.CompetitionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionQuestionRepository extends JpaRepository<CompetitionQuestion,Long> {
}
