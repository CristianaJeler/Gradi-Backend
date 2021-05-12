package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.answerRelated.AnswerMediaEntity;
import com.gradi.app.activities.model.answerRelated.AnswerMediaKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerMediaRepository extends JpaRepository<AnswerMediaEntity, AnswerMediaKey> {
    @Query(value = "select * from answers_media where answer_id=:answerId", nativeQuery = true)
    List<AnswerMediaEntity> findAllByAnswerId(String answerId);
}
