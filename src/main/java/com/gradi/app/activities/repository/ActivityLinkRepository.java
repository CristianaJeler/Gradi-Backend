package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.linkRelated.ActivityLinkEntity;
import com.gradi.app.activities.model.linkRelated.ActivityLinkKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActivityLinkRepository extends JpaRepository<ActivityLinkEntity, ActivityLinkKey> {
    @Transactional
    @Query(value = "SELECT * from activities_links ua where activity_id=:actId", nativeQuery = true)
    List<ActivityLinkEntity> findAllByActivityId(String actId);
}
