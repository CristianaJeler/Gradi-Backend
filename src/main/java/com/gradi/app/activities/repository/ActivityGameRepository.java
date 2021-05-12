package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.userRelated.ActivityUserEntity;
import com.gradi.app.game.model.ActivityGameEntity;
import com.gradi.app.game.model.ActivityGameKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActivityGameRepository extends JpaRepository<ActivityGameEntity, ActivityGameKey> {
    @Transactional
    @Query(value = "SELECT * from activities_games ag where activity_id=:actId", nativeQuery = true)
    List<ActivityGameEntity> findAllByActivityId(String actId);
}
