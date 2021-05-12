package com.gradi.app.activities.repository;

import com.gradi.app.activities.model.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity,String> {

    List<ActivityEntity> findAllByGroupId(String groupId);
}
