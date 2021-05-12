package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.answerRelated.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity,String> {
    @Query(value = "select * from results where answer_id=:answerId", nativeQuery = true)
    List<ResultEntity> findAllByAnswerId(String answerId);
}
