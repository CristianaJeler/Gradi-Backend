package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.userRelated.ActivityUserEntity;
import com.gradi.app.activities.model.userRelated.ActivityUserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ActivityUserRepository extends JpaRepository<ActivityUserEntity, ActivityUserKey> {
    @Transactional
    @Query(value = "SELECT * from users_activities ua where user_id=:userId", nativeQuery = true)
    List<ActivityUserEntity> findAllByUserId(String userId);
}
