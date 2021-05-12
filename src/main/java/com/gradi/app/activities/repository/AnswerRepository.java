package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.answerRelated.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity,String> {
    @Query(value = "select * from answers where activity_id=:activityId order by added_at desc", nativeQuery = true)
    List<AnswerEntity> findAllByActivityIdOrderByAddedAt(String activityId);
}
