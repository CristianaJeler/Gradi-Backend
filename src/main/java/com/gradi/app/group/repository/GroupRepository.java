package com.gradi.app.group.repository;


import com.gradi.app.group.model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, String> {
    Optional<GroupEntity> findById(String id);
}
