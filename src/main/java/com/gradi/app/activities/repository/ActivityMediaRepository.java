package com.gradi.app.activities.repository;


import com.gradi.app.activities.model.mediaRelated.ActivityMediaEntity;
import com.gradi.app.activities.model.mediaRelated.ActivityMediaKey;
import com.gradi.app.game.model.ActivityGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActivityMediaRepository extends JpaRepository<ActivityMediaEntity, ActivityMediaKey> {
    @Transactional
    @Query(value = "SELECT * from activities_media am where activity_id=:actId", nativeQuery = true)
    List<ActivityMediaEntity> findAllByActivityId(String actId);
}
